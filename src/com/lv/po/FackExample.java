package com.lv.po;

import java.util.ArrayList;
import java.util.List;

public class FackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FackExample() {
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

        public Criteria andFIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFStartIsNull() {
            addCriterion("f_start is null");
            return (Criteria) this;
        }

        public Criteria andFStartIsNotNull() {
            addCriterion("f_start is not null");
            return (Criteria) this;
        }

        public Criteria andFStartEqualTo(String value) {
            addCriterion("f_start =", value, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartNotEqualTo(String value) {
            addCriterion("f_start <>", value, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartGreaterThan(String value) {
            addCriterion("f_start >", value, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartGreaterThanOrEqualTo(String value) {
            addCriterion("f_start >=", value, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartLessThan(String value) {
            addCriterion("f_start <", value, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartLessThanOrEqualTo(String value) {
            addCriterion("f_start <=", value, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartLike(String value) {
            addCriterion("f_start like", value, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartNotLike(String value) {
            addCriterion("f_start not like", value, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartIn(List<String> values) {
            addCriterion("f_start in", values, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartNotIn(List<String> values) {
            addCriterion("f_start not in", values, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartBetween(String value1, String value2) {
            addCriterion("f_start between", value1, value2, "fStart");
            return (Criteria) this;
        }

        public Criteria andFStartNotBetween(String value1, String value2) {
            addCriterion("f_start not between", value1, value2, "fStart");
            return (Criteria) this;
        }

        public Criteria andFEndIsNull() {
            addCriterion("f_end is null");
            return (Criteria) this;
        }

        public Criteria andFEndIsNotNull() {
            addCriterion("f_end is not null");
            return (Criteria) this;
        }

        public Criteria andFEndEqualTo(String value) {
            addCriterion("f_end =", value, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndNotEqualTo(String value) {
            addCriterion("f_end <>", value, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndGreaterThan(String value) {
            addCriterion("f_end >", value, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndGreaterThanOrEqualTo(String value) {
            addCriterion("f_end >=", value, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndLessThan(String value) {
            addCriterion("f_end <", value, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndLessThanOrEqualTo(String value) {
            addCriterion("f_end <=", value, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndLike(String value) {
            addCriterion("f_end like", value, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndNotLike(String value) {
            addCriterion("f_end not like", value, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndIn(List<String> values) {
            addCriterion("f_end in", values, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndNotIn(List<String> values) {
            addCriterion("f_end not in", values, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndBetween(String value1, String value2) {
            addCriterion("f_end between", value1, value2, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFEndNotBetween(String value1, String value2) {
            addCriterion("f_end not between", value1, value2, "fEnd");
            return (Criteria) this;
        }

        public Criteria andFReasonIsNull() {
            addCriterion("f_reason is null");
            return (Criteria) this;
        }

        public Criteria andFReasonIsNotNull() {
            addCriterion("f_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFReasonEqualTo(String value) {
            addCriterion("f_reason =", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonNotEqualTo(String value) {
            addCriterion("f_reason <>", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonGreaterThan(String value) {
            addCriterion("f_reason >", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonGreaterThanOrEqualTo(String value) {
            addCriterion("f_reason >=", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonLessThan(String value) {
            addCriterion("f_reason <", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonLessThanOrEqualTo(String value) {
            addCriterion("f_reason <=", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonLike(String value) {
            addCriterion("f_reason like", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonNotLike(String value) {
            addCriterion("f_reason not like", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonIn(List<String> values) {
            addCriterion("f_reason in", values, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonNotIn(List<String> values) {
            addCriterion("f_reason not in", values, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonBetween(String value1, String value2) {
            addCriterion("f_reason between", value1, value2, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonNotBetween(String value1, String value2) {
            addCriterion("f_reason not between", value1, value2, "fReason");
            return (Criteria) this;
        }

        public Criteria andFStatusIsNull() {
            addCriterion("f_status is null");
            return (Criteria) this;
        }

        public Criteria andFStatusIsNotNull() {
            addCriterion("f_status is not null");
            return (Criteria) this;
        }

        public Criteria andFStatusEqualTo(String value) {
            addCriterion("f_status =", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusNotEqualTo(String value) {
            addCriterion("f_status <>", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusGreaterThan(String value) {
            addCriterion("f_status >", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusGreaterThanOrEqualTo(String value) {
            addCriterion("f_status >=", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusLessThan(String value) {
            addCriterion("f_status <", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusLessThanOrEqualTo(String value) {
            addCriterion("f_status <=", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusLike(String value) {
            addCriterion("f_status like", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusNotLike(String value) {
            addCriterion("f_status not like", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusIn(List<String> values) {
            addCriterion("f_status in", values, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusNotIn(List<String> values) {
            addCriterion("f_status not in", values, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusBetween(String value1, String value2) {
            addCriterion("f_status between", value1, value2, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusNotBetween(String value1, String value2) {
            addCriterion("f_status not between", value1, value2, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFSidIsNull() {
            addCriterion("f_sId is null");
            return (Criteria) this;
        }

        public Criteria andFSidIsNotNull() {
            addCriterion("f_sId is not null");
            return (Criteria) this;
        }

        public Criteria andFSidEqualTo(Integer value) {
            addCriterion("f_sId =", value, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidNotEqualTo(Integer value) {
            addCriterion("f_sId <>", value, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidGreaterThan(Integer value) {
            addCriterion("f_sId >", value, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_sId >=", value, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidLessThan(Integer value) {
            addCriterion("f_sId <", value, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidLessThanOrEqualTo(Integer value) {
            addCriterion("f_sId <=", value, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidIn(List<Integer> values) {
            addCriterion("f_sId in", values, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidNotIn(List<Integer> values) {
            addCriterion("f_sId not in", values, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidBetween(Integer value1, Integer value2) {
            addCriterion("f_sId between", value1, value2, "fSid");
            return (Criteria) this;
        }

        public Criteria andFSidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_sId not between", value1, value2, "fSid");
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