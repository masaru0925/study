/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityConverter;

import java.util.List;

/**
 *
 * @author msaiki
 */
public class Entity {
	private String name;
	private List<Query> queries;

	public Entity() {
	}

	@Override
	public String toString() {
		return "Entity{" + "name=" + name + ", queries=" + queries + '}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Query> getQueries() {
		return queries;
	}

	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}
	
	
}
