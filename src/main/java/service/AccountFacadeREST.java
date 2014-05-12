/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.glassfish.jersey.server.JSONP;
//import org.glassfish.jersey.server.JSONP;
import w.Account;

/**
 *
 * @author masaru
 */
@Stateless
@Path("w.account")
public class AccountFacadeREST extends AbstractFacade<Account> {
		@PersistenceContext(unitName = "w_mavenproject1_war_1.0-SNAPSHOTPU")
		private EntityManager em;

		public AccountFacadeREST() {
				super(Account.class);
		}

		@POST
        @Override
        @Consumes({"application/xml", "application/json"})
		public void create(Account entity) {
				super.create(entity);
		}

		@PUT
        @Path("{id}")
        @Consumes({"application/xml", "application/json"})
		public void edit(@PathParam("id") Integer id, Account entity) {
				super.edit(entity);
		}

		@DELETE
        @Path("{id}")
		public void remove(@PathParam("id") Integer id) {
				super.remove(super.find(id));
		}
		@GET
        @Path("{id}")
        @Produces({"application/xml", "application/json"})
		public Account find(@PathParam("id") Integer id) {
				return super.find(id);
		}
		@GET
        @Path("jsonp/{id}") //元のパスとは違うものを設定
		@Produces("application/x-javascript") //これだけを設定
		@JSONP(queryParam = JSONP.DEFAULT_CALLBACK) //jersey-serverが必要
		public Account find(@QueryParam(JSONP.DEFAULT_CALLBACK) String callback, @PathParam("id") Integer id) {
				return super.find(id);
		}

		@GET
        @Override
        @Produces({"application/xml", "application/json"})
		public List<Account> findAll() {
				return super.findAll();
		}

		@GET
        @Path("jsonp") //元のパスとは違うものを設定
		@Produces("application/x-javascript") //これだけを設定
		@JSONP(queryParam = JSONP.DEFAULT_CALLBACK) //jersey-serverが必要
		public List<Account> findAll(@QueryParam(JSONP.DEFAULT_CALLBACK) String callback) {
				return super.findAll();
		}

		@GET
        @Path("{from}/{to}")
        @Produces({"application/xml", "application/json"})
		public List<Account> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
				return super.findRange(new int[]{from, to});
		}

		@GET
        @Path("count")
        @Produces("text/plain")
		public String countREST() {
				return String.valueOf(super.count());
		}

		@Override
		protected EntityManager getEntityManager() {
				return em;
		}
		
}
