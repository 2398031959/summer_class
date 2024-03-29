package com.lv.po;

import java.util.ArrayList;
import java.util.List;

public class ClassTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassTypeExample() {
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

        public Criteria andCtIdIsNull() {
            addCriterion("ct_id is null");
            return (Criteria) this;
        }

        public Criteria andCtIdIsNotNull() {
            addCriterion("ct_id is not null");
            return (Criteria) this;
        }

        public Criteria andCtIdEqualTo(Integer value) {
            addCriterion("ct_id =", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotEqualTo(Integer value) {
            addCriterion("ct_id <>", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdGreaterThan(Integer value) {
            addCriterion("ct_id >", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ct_id >=", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLessThan(Integer value) {
            addCriterion("ct_id <", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLessThanOrEqualTo(Integer value) {
            addCriterion("ct_id <=", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdIn(List<Integer> values) {
            addCriterion("ct_id in", values, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotIn(List<Integer> values) {
            addCriterion("ct_id not in", values, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdBetween(Integer value1, Integer value2) {
            addCriterion("ct_id between", value1, value2, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ct_id not between", value1, value2, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtNameIsNull() {
            addCriterion("ct_name is null");
            return (Criteria) this;
        }

        public Criteria andCtNameIsNotNull() {
            addCriterion("ct_name is not null");
            return (Criteria) this;
        }

        public Criteria andCtNameEqualTo(String value) {
            addCriterion("ct_name =", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameNotEqualTo(String value) {
            addCriterion("ct_name <>", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameGreaterThan(String value) {
            addCriterion("ct_name >", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameGreaterThanOrEqualTo(String value) {
            addCriterion("ct_name >=", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameLessThan(String value) {
            addCriterion("ct_name <", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameLessThanOrEqualTo(String value) {
            addCriterion("ct_name <=", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameLike(String value) {
            addCriterion("ct_name like", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameNotLike(String value) {
            addCriterion("ct_name not like", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameIn(List<String> values) {
            addCriterion("ct_name in", values, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameNotIn(List<String> values) {
            addCriterion("ct_name not in", values, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameBetween(String value1, String value2) {
            addCriterion("ct_name between", value1, value2, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameNotBetween(String value1, String value2) {
            addCriterion("ct_name not between", value1, value2, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtPriceIsNull() {
            addCriterion("ct_price is null");
            return (Criteria) this;
        }

        public Criteria andCtPriceIsNotNull() {
            addCriterion("ct_price is not null");
            return (Criteria) this;
        }

        public Criteria andCtPriceEqualTo(Integer value) {
            addCriterion("ct_price =", value, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceNotEqualTo(Integer value) {
            addCriterion("ct_price <>", value, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceGreaterThan(Integer value) {
            addCriterion("ct_price >", value, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ct_price >=", value, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceLessThan(Integer value) {
            addCriterion("ct_price <", value, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceLessThanOrEqualTo(Integer value) {
            addCriterion("ct_price <=", value, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceIn(List<Integer> values) {
            addCriterion("ct_price in", values, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceNotIn(List<Integer> values) {
            addCriterion("ct_price not in", values, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceBetween(Integer value1, Integer value2) {
            addCriterion("ct_price between", value1, value2, "ctPrice");
            return (Criteria) this;
        }

        public Criteria andCtPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("ct_price not between", value1, value2, "ctPrice");
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