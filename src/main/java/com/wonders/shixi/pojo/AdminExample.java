package com.wonders.shixi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIsNull() {
            addCriterion("admin_password is null");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIsNotNull() {
            addCriterion("admin_password is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordEqualTo(String value) {
            addCriterion("admin_password =", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotEqualTo(String value) {
            addCriterion("admin_password <>", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordGreaterThan(String value) {
            addCriterion("admin_password >", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("admin_password >=", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLessThan(String value) {
            addCriterion("admin_password <", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLessThanOrEqualTo(String value) {
            addCriterion("admin_password <=", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLike(String value) {
            addCriterion("admin_password like", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotLike(String value) {
            addCriterion("admin_password not like", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIn(List<String> values) {
            addCriterion("admin_password in", values, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotIn(List<String> values) {
            addCriterion("admin_password not in", values, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordBetween(String value1, String value2) {
            addCriterion("admin_password between", value1, value2, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotBetween(String value1, String value2) {
            addCriterion("admin_password not between", value1, value2, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionIsNull() {
            addCriterion("admin_jurisdiction is null");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionIsNotNull() {
            addCriterion("admin_jurisdiction is not null");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionEqualTo(Integer value) {
            addCriterion("admin_jurisdiction =", value, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionNotEqualTo(Integer value) {
            addCriterion("admin_jurisdiction <>", value, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionGreaterThan(Integer value) {
            addCriterion("admin_jurisdiction >", value, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_jurisdiction >=", value, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionLessThan(Integer value) {
            addCriterion("admin_jurisdiction <", value, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionLessThanOrEqualTo(Integer value) {
            addCriterion("admin_jurisdiction <=", value, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionIn(List<Integer> values) {
            addCriterion("admin_jurisdiction in", values, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionNotIn(List<Integer> values) {
            addCriterion("admin_jurisdiction not in", values, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionBetween(Integer value1, Integer value2) {
            addCriterion("admin_jurisdiction between", value1, value2, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminJurisdictionNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_jurisdiction not between", value1, value2, "adminJurisdiction");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateIsNull() {
            addCriterion("admin_update is null");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateIsNotNull() {
            addCriterion("admin_update is not null");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateEqualTo(Date value) {
            addCriterion("admin_update =", value, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateNotEqualTo(Date value) {
            addCriterion("admin_update <>", value, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateGreaterThan(Date value) {
            addCriterion("admin_update >", value, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("admin_update >=", value, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateLessThan(Date value) {
            addCriterion("admin_update <", value, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateLessThanOrEqualTo(Date value) {
            addCriterion("admin_update <=", value, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateIn(List<Date> values) {
            addCriterion("admin_update in", values, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateNotIn(List<Date> values) {
            addCriterion("admin_update not in", values, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateBetween(Date value1, Date value2) {
            addCriterion("admin_update between", value1, value2, "adminUpdate");
            return (Criteria) this;
        }

        public Criteria andAdminUpdateNotBetween(Date value1, Date value2) {
            addCriterion("admin_update not between", value1, value2, "adminUpdate");
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