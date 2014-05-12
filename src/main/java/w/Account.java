/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package w;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author masaru
 */
@Entity
@Table(name = "ACCOUNT")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
		@NamedQuery(name = "Account.findByModifiedByJobid", query = "SELECT a FROM Account a WHERE a.modifiedByJobid = :modifiedByJobid"),
		@NamedQuery(name = "Account.findByModifiedByName", query = "SELECT a FROM Account a WHERE a.modifiedByName = :modifiedByName"),
		@NamedQuery(name = "Account.findByModifiedAt", query = "SELECT a FROM Account a WHERE a.modifiedAt = :modifiedAt"),
		@NamedQuery(name = "Account.findByRecordDate", query = "SELECT a FROM Account a WHERE a.recordDate = :recordDate"),
		@NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
		@NamedQuery(name = "Account.findByCountryCode", query = "SELECT a FROM Account a WHERE a.countryCode = :countryCode"),
		@NamedQuery(name = "Account.findByBankCode", query = "SELECT a FROM Account a WHERE a.bankCode = :bankCode"),
		@NamedQuery(name = "Account.findByBranchNumber", query = "SELECT a FROM Account a WHERE a.branchNumber = :branchNumber"),
		@NamedQuery(name = "Account.findByAccountNumber", query = "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber"),
		@NamedQuery(name = "Account.findByCustomerBranch", query = "SELECT a FROM Account a WHERE a.customerBranch = :customerBranch"),
		@NamedQuery(name = "Account.findByCustomerId", query = "SELECT a FROM Account a WHERE a.customerId = :customerId"),
		@NamedQuery(name = "Account.findByIsMybank", query = "SELECT a FROM Account a WHERE a.isMybank = :isMybank"),
		@NamedQuery(name = "Account.findByIsClosed", query = "SELECT a FROM Account a WHERE a.isClosed = :isClosed"),
		@NamedQuery(name = "Account.findByClosedAt", query = "SELECT a FROM Account a WHERE a.closedAt = :closedAt")})
public class Account implements Serializable {
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
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "ID")
		private Integer id;
		@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 5)
        @Column(name = "COUNTRY_CODE")
		private String countryCode;
		@Basic(optional = false)
        @NotNull
        @Column(name = "BANK_CODE")
		private int bankCode;
		@Basic(optional = false)
        @NotNull
        @Column(name = "BRANCH_NUMBER")
		private int branchNumber;
		@Basic(optional = false)
        @NotNull
        @Column(name = "ACCOUNT_NUMBER")
		private int accountNumber;
		@Column(name = "CUSTOMER_BRANCH")
		private Integer customerBranch;
		@Column(name = "CUSTOMER_ID")
		private Integer customerId;
		@Basic(optional = false)
        @NotNull
        @Column(name = "IS_MYBANK")
		private int isMybank;
		@Basic(optional = false)
        @NotNull
        @Column(name = "IS_CLOSED")
		private int isClosed;
		@Column(name = "CLOSED_AT")
		private Integer closedAt;
		@JoinColumn(name = "ACCOUNT_TYPE_CODE", referencedColumnName = "CODE")
        @ManyToOne(optional = false)
		private AccountType accountTypeCode;

		public Account() {
		}

		public Account(Integer id) {
				this.id = id;
		}

		public Account(Integer id, String recordDate, String countryCode, int bankCode, int branchNumber, int accountNumber, int isMybank, int isClosed) {
				this.id = id;
				this.recordDate = recordDate;
				this.countryCode = countryCode;
				this.bankCode = bankCode;
				this.branchNumber = branchNumber;
				this.accountNumber = accountNumber;
				this.isMybank = isMybank;
				this.isClosed = isClosed;
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

		public Integer getId() {
				return id;
		}

		public void setId(Integer id) {
				this.id = id;
		}

		public String getCountryCode() {
				return countryCode;
		}

		public void setCountryCode(String countryCode) {
				this.countryCode = countryCode;
		}

		public int getBankCode() {
				return bankCode;
		}

		public void setBankCode(int bankCode) {
				this.bankCode = bankCode;
		}

		public int getBranchNumber() {
				return branchNumber;
		}

		public void setBranchNumber(int branchNumber) {
				this.branchNumber = branchNumber;
		}

		public int getAccountNumber() {
				return accountNumber;
		}

		public void setAccountNumber(int accountNumber) {
				this.accountNumber = accountNumber;
		}

		public Integer getCustomerBranch() {
				return customerBranch;
		}

		public void setCustomerBranch(Integer customerBranch) {
				this.customerBranch = customerBranch;
		}

		public Integer getCustomerId() {
				return customerId;
		}

		public void setCustomerId(Integer customerId) {
				this.customerId = customerId;
		}

		public int getIsMybank() {
				return isMybank;
		}

		public void setIsMybank(int isMybank) {
				this.isMybank = isMybank;
		}

		public int getIsClosed() {
				return isClosed;
		}

		public void setIsClosed(int isClosed) {
				this.isClosed = isClosed;
		}

		public Integer getClosedAt() {
				return closedAt;
		}

		public void setClosedAt(Integer closedAt) {
				this.closedAt = closedAt;
		}

		public AccountType getAccountTypeCode() {
				return accountTypeCode;
		}

		public void setAccountTypeCode(AccountType accountTypeCode) {
				this.accountTypeCode = accountTypeCode;
		}

		@Override
		public int hashCode() {
				int hash = 0;
				hash += (id != null ? id.hashCode() : 0);
				return hash;
		}

		@Override
		public boolean equals(Object object) {
				// TODO: Warning - this method won't work in the case the id fields are not set
				if (!(object instanceof Account)) {
						return false;
				}
				Account other = (Account) object;
				if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
						return false;
				}
				return true;
		}

		@Override
		public String toString() {
				return "w.Account[ id=" + id + " ]";
		}
		
}
