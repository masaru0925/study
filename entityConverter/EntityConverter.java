/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityConverter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;

/**
 *
 * @author msaiki
 */
public class EntityConverter {
	private static final Logger LOG = Logger.getLogger(EntityConverter.class.getName());


	public static void main(String args[]) throws IOException, JAXBException, ClassNotFoundException {
		EntityConverter converter = new EntityConverter();
		String filePath = "src/Message.xml";
		File file = new File(filePath);
		FileReader fileReader = new FileReader(file);
		Entity entity = JAXB.unmarshal(file, Entity.class);
		EntityModify modify = converter.createNamedQueries(entity.getQueries());
		LOG.log(Level.INFO, modify.namedQuery);
		LOG.log(Level.INFO, modify.staticQueryName);
		LOG.log(Level.INFO, modify.staticParamName);
		
		List lines = Files.readAllLines(Paths.get(filePath), Charset.forName("UTF-8"));
//		String source = 
	}

	/**
	 * read source code
	 * find <EntityConverter>.....</EntityConverter>
	 * if(true)
	 * 	replase
	 * else
	 * 	find pattern (public class .... $)
	 */
	private EntityModify createNamedQueries(List<Query> queries){
		StringBuilder namedQueryBuilder = new StringBuilder();
		StringBuilder staticQueryNameBuilder = new StringBuilder();
		StringBuilder staticParamNameBuilder = new StringBuilder();
		for(Query query: queries){
			namedQueryBuilder
				.append("@NamedQuery(name=\"")
				.append(query.getName())
				.append("\", query=\"")
				.append(query.getStatement()
					.replaceAll("\r\n", "")
					.replaceAll("\n", ""))
				.append("\")\n")
				;
			staticQueryNameBuilder
				.append("public static final String QUERY_")
				.append(query.getName())
				.append(" = \"")
				.append(query.getName())
				.append("\";\n")
				;
			if(null != query.getParameters()){
				for(String paramName: query.getParameters()){
					staticParamNameBuilder
						.append("public static final String PARAM_")
						.append(paramName)
						.append(" = \"")
						.append(paramName)
						.append("\";\n")
						;
				}
			}
		}
		EntityModify modify = new EntityModify();
		modify.namedQuery = namedQueryBuilder.toString();
		modify.staticQueryName = staticQueryNameBuilder.toString();
		modify.staticParamName = staticParamNameBuilder.toString();
		
		return modify;
	}

	class EntityModify {
		String namedQuery;
		String staticQueryName;
		String staticParamName;

	}


}
