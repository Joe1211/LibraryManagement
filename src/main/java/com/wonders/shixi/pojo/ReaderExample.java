package com.wonders.shixi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReaderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andReaderIdIsNull() {
            addCriterion("reader_id is null");
            return (Criteria) this;
        }

        public Criteria andReaderIdIsNotNull() {
            addCriterion("reader_id is not null");
            return (Criteria) this;
        }

        public Criteria andReaderIdEqualTo(Integer value) {
            addCriterion("reader_id =", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotEqualTo(Integer value) {
            addCriterion("reader_id <>", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdGreaterThan(Integer value) {
            addCriterion("reader_id >", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reader_id >=", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdLessThan(Integer value) {
            addCriterion("reader_id <", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("reader_id <=", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdIn(List<Integer> values) {
            addCriterion("reader_id in", values, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotIn(List<Integer> values) {
            addCriterion("reader_id not in", values, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdBetween(Integer value1, Integer value2) {
            addCriterion("reader_id between", value1, value2, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reader_id not between", value1, value2, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderNameIsNull() {
            addCriterion("reader_name is null");
            return (Criteria) this;
        }

        public Criteria andReaderNameIsNotNull() {
            addCriterion("reader_name is not null");
            return (Criteria) this;
        }

        public Criteria andReaderNameEqualTo(String value) {
            addCriterion("reader_name =", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotEqualTo(String value) {
            addCriterion("reader_name <>", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameGreaterThan(String value) {
            addCriterion("reader_name >", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("reader_name >=", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLessThan(String value) {
            addCriterion("reader_name <", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLessThanOrEqualTo(String value) {
            addCriterion("reader_name <=", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLike(String value) {
            addCriterion("reader_name like", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotLike(String value) {
            addCriterion("reader_name not like", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameIn(List<String> values) {
            addCriterion("reader_name in", values, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotIn(List<String> values) {
            addCriterion("reader_name not in", values, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameBetween(String value1, String value2) {
            addCriterion("reader_name between", value1, value2, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotBetween(String value1, String value2) {
            addCriterion("reader_name not between", value1, value2, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneIsNull() {
            addCriterion("reader_phone is null");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneIsNotNull() {
            addCriterion("reader_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneEqualTo(String value) {
            addCriterion("reader_phone =", value, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneNotEqualTo(String value) {
            addCriterion("reader_phone <>", value, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneGreaterThan(String value) {
            addCriterion("reader_phone >", value, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("reader_phone >=", value, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneLessThan(String value) {
            addCriterion("reader_phone <", value, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneLessThanOrEqualTo(String value) {
            addCriterion("reader_phone <=", value, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneLike(String value) {
            addCriterion("reader_phone like", value, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneNotLike(String value) {
            addCriterion("reader_phone not like", value, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneIn(List<String> values) {
            addCriterion("reader_phone in", values, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneNotIn(List<String> values) {
            addCriterion("reader_phone not in", values, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneBetween(String value1, String value2) {
            addCriterion("reader_phone between", value1, value2, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderPhoneNotBetween(String value1, String value2) {
            addCriterion("reader_phone not between", value1, value2, "readerPhone");
            return (Criteria) this;
        }

        public Criteria andReaderEmailIsNull() {
            addCriterion("reader_email is null");
            return (Criteria) this;
        }

        public Criteria andReaderEmailIsNotNull() {
            addCriterion("reader_email is not null");
            return (Criteria) this;
        }

        public Criteria andReaderEmailEqualTo(String value) {
            addCriterion("reader_email =", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailNotEqualTo(String value) {
            addCriterion("reader_email <>", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailGreaterThan(String value) {
            addCriterion("reader_email >", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailGreaterThanOrEqualTo(String value) {
            addCriterion("reader_email >=", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailLessThan(String value) {
            addCriterion("reader_email <", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailLessThanOrEqualTo(String value) {
            addCriterion("reader_email <=", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailLike(String value) {
            addCriterion("reader_email like", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailNotLike(String value) {
            addCriterion("reader_email not like", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailIn(List<String> values) {
            addCriterion("reader_email in", values, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailNotIn(List<String> values) {
            addCriterion("reader_email not in", values, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailBetween(String value1, String value2) {
            addCriterion("reader_email between", value1, value2, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailNotBetween(String value1, String value2) {
            addCriterion("reader_email not between", value1, value2, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistIsNull() {
            addCriterion("reader_blacklist is null");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistIsNotNull() {
            addCriterion("reader_blacklist is not null");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistEqualTo(Integer value) {
            addCriterion("reader_blacklist =", value, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistNotEqualTo(Integer value) {
            addCriterion("reader_blacklist <>", value, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistGreaterThan(Integer value) {
            addCriterion("reader_blacklist >", value, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistGreaterThanOrEqualTo(Integer value) {
            addCriterion("reader_blacklist >=", value, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistLessThan(Integer value) {
            addCriterion("reader_blacklist <", value, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistLessThanOrEqualTo(Integer value) {
            addCriterion("reader_blacklist <=", value, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistIn(List<Integer> values) {
            addCriterion("reader_blacklist in", values, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistNotIn(List<Integer> values) {
            addCriterion("reader_blacklist not in", values, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistBetween(Integer value1, Integer value2) {
            addCriterion("reader_blacklist between", value1, value2, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderBlacklistNotBetween(Integer value1, Integer value2) {
            addCriterion("reader_blacklist not between", value1, value2, "readerBlacklist");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateIsNull() {
            addCriterion("reader_update is null");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateIsNotNull() {
            addCriterion("reader_update is not null");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateEqualTo(Date value) {
            addCriterion("reader_update =", value, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateNotEqualTo(Date value) {
            addCriterion("reader_update <>", value, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateGreaterThan(Date value) {
            addCriterion("reader_update >", value, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("reader_update >=", value, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateLessThan(Date value) {
            addCriterion("reader_update <", value, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateLessThanOrEqualTo(Date value) {
            addCriterion("reader_update <=", value, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateIn(List<Date> values) {
            addCriterion("reader_update in", values, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateNotIn(List<Date> values) {
            addCriterion("reader_update not in", values, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateBetween(Date value1, Date value2) {
            addCriterion("reader_update between", value1, value2, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderUpdateNotBetween(Date value1, Date value2) {
            addCriterion("reader_update not between", value1, value2, "readerUpdate");
            return (Criteria) this;
        }

        public Criteria andReaderStateIsNull() {
            addCriterion("reader_state is null");
            return (Criteria) this;
        }

        public Criteria andReaderStateIsNotNull() {
            addCriterion("reader_state is not null");
            return (Criteria) this;
        }

        public Criteria andReaderStateEqualTo(Integer value) {
            addCriterion("reader_state =", value, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateNotEqualTo(Integer value) {
            addCriterion("reader_state <>", value, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateGreaterThan(Integer value) {
            addCriterion("reader_state >", value, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("reader_state >=", value, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateLessThan(Integer value) {
            addCriterion("reader_state <", value, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateLessThanOrEqualTo(Integer value) {
            addCriterion("reader_state <=", value, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateIn(List<Integer> values) {
            addCriterion("reader_state in", values, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateNotIn(List<Integer> values) {
            addCriterion("reader_state not in", values, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateBetween(Integer value1, Integer value2) {
            addCriterion("reader_state between", value1, value2, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("reader_state not between", value1, value2, "readerState");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceIsNull() {
            addCriterion("reader_balance is null");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceIsNotNull() {
            addCriterion("reader_balance is not null");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceEqualTo(Double value) {
            addCriterion("reader_balance =", value, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceNotEqualTo(Double value) {
            addCriterion("reader_balance <>", value, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceGreaterThan(Double value) {
            addCriterion("reader_balance >", value, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("reader_balance >=", value, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceLessThan(Double value) {
            addCriterion("reader_balance <", value, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceLessThanOrEqualTo(Double value) {
            addCriterion("reader_balance <=", value, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceIn(List<Double> values) {
            addCriterion("reader_balance in", values, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceNotIn(List<Double> values) {
            addCriterion("reader_balance not in", values, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceBetween(Double value1, Double value2) {
            addCriterion("reader_balance between", value1, value2, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderBalanceNotBetween(Double value1, Double value2) {
            addCriterion("reader_balance not between", value1, value2, "readerBalance");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordIsNull() {
            addCriterion("reader_password is null");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordIsNotNull() {
            addCriterion("reader_password is not null");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordEqualTo(String value) {
            addCriterion("reader_password =", value, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordNotEqualTo(String value) {
            addCriterion("reader_password <>", value, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordGreaterThan(String value) {
            addCriterion("reader_password >", value, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("reader_password >=", value, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordLessThan(String value) {
            addCriterion("reader_password <", value, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordLessThanOrEqualTo(String value) {
            addCriterion("reader_password <=", value, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordLike(String value) {
            addCriterion("reader_password like", value, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordNotLike(String value) {
            addCriterion("reader_password not like", value, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordIn(List<String> values) {
            addCriterion("reader_password in", values, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordNotIn(List<String> values) {
            addCriterion("reader_password not in", values, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordBetween(String value1, String value2) {
            addCriterion("reader_password between", value1, value2, "readerPassword");
            return (Criteria) this;
        }

        public Criteria andReaderPasswordNotBetween(String value1, String value2) {
            addCriterion("reader_password not between", value1, value2, "readerPassword");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}