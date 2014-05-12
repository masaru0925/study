/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package w;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author masaru
 */
@Entity
@Table(name = "ACCOUNT_TYPE")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "AccountType.findAll", query = "SELECT a FROM AccountType a"),
		@NamedQuery(name = "AccountType.findByModifiedByJobid", query = "SELECT a FROM AccountType a WHERE a.modifiedByJobid = :modifiedByJobid"),
		@NamedQuery(name = "AccountType.findByModifiedByName", query = "SELECT a FROM AccountType a WHERE a.modifiedByName = :modifiedByName"),
		@NamedQuery(name = "AccountType.findByModifiedAt", query = "SELECT a FROM AccountType a WHERE a.modifiedAt = :modifiedAt"),
		@NamedQuery(name = "AccountType.findByRecordDate", query = "SELECT a FROM AccountType a WHERE a.recordDate = :recordDate"),
		@NamedQuery(name = "AccountType.findByCode", query = "SELECT a FROM AccountType a WHERE a.code = :code"),
		@NamedQuery(name = "AccountType.findByName", query = "SELECT a FROM AccountType a WHERE a.name = :name"),
		@NamedQuery(name = "AccountType.findByIsLiquid", query = "SELECT a FROM AccountType a WHERE a.isLiquid = :isLiquid")})
public class AccountType implements Serializable {
		private static final long serialVersionUID = 1L;
		@Size(max = 30)
        @Column(name = "MODIFIED_BY_JOBID")
		private String modifiedByJobid;
		@Size(max = 30)
        @Column(name = "MODIFIED_BY_NAME")
		private String modifiedByName;
		@Size(max = 17)
        @Column(name = "MODIFIED_AT")
		private String modifiedAt;
		@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 8)
        @Column(name = "RECORD_DATE")
		private String recordDate;
		@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "CODE")
		private Integer code;
		@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 24)
        @Column(name = "NAME")
		private String name;
		@Basic(optional = false)
        @NotNull
        @Column(name = "IS_LIQUID")
		private int isLiquid;
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeCode")
		private Collection<Account> accountCollection;

		public AccountType() {
		}

		public AccountType(Integer code) {
				this.code = code;
		}

		public AccountType(Integer code, String recordDate, String name, int isLiquid) {
				this.code = code;
				this.recordDate = recordDate;
				this.name = name;
				this.isLiquid = isLiquid;
		}

		public String getModifiedByJobid() {
				return modifiedByJobid;
		}

		public void setModifiedByJobid(String modifiedByJobid) {
				this.modifiedByJobid = modifiedByJobid;
		}

		public String getModifiedByName() {
				return modifiedByName;
		}

		public void setModifiedByName(String modifiedByName) {
				this.modifiedByName = modifiedByName;
		}

		public String getModifiedAt() {
				return modifiedAt;
		}

		public void setModifiedAt(String modifiedAt) {
				this.modifiedAt = modifiedAt;
		}

		public String getRecordDate() {
				return recordDate;
		}

		public void setRecordDate(String recordDate) {
				this.recordDate = recordDate;
		}

		public Integer getCode() {
				return code;
		}

		public void setCode(Integer code) {
				this.code = code;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public int getIsLiquid() {
				return isLiquid;
		}

		public void setIsLiquid(int isLiquid) {
				this.isLiquid = isLiquid;
		}

		@XmlTransient
		public Collection<Account> getAccountCollection() {
				return accountCollection;
		}

		public void setAccountCollection(Collection<Account> accountCollection) {
				this.accountCollection = accountCollection;
		}

		@Override
		public int hashCode() {
				int hash = 0;
				hash += (code != null ? code.hashCode() : 0);
				return hash;
		}

		@Override
		public boolean equals(Object object) {
				// TODO: Warning - this method won't work in the case the id fields are not set
				if (!(object instanceof AccountType)) {
						return false;
				}
				AccountType other = (AccountType) object;
				if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
						return false;
				}
				return true;
		}

		@Override
		public String toString() {
				return "w.AccountType[ code=" + code + " ]";
		}
		
}
