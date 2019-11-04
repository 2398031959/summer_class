package com.lv.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(Integer value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(Integer value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(Integer value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(Integer value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<Integer> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<Integer> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(Integer value1, Integer value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTNameIsNull() {
            addCriterion("t_name is null");
            return (Criteria) this;
        }

        public Criteria andTNameIsNotNull() {
            addCriterion("t_name is not null");
            return (Criteria) this;
        }

        public Criteria andTNameEqualTo(String value) {
            addCriterion("t_name =", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotEqualTo(String value) {
            addCriterion("t_name <>", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThan(String value) {
            addCriterion("t_name >", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_name >=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThan(String value) {
            addCriterion("t_name <", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThanOrEqualTo(String value) {
            addCriterion("t_name <=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLike(String value) {
            addCriterion("t_name like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotLike(String value) {
            addCriterion("t_name not like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameIn(List<String> values) {
            addCriterion("t_name in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotIn(List<String> values) {
            addCriterion("t_name not in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameBetween(String value1, String value2) {
            addCriterion("t_name between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotBetween(String value1, String value2) {
            addCriterion("t_name not between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTSexIsNull() {
            addCriterion("t_sex is null");
            return (Criteria) this;
        }

        public Criteria andTSexIsNotNull() {
            addCriterion("t_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTSexEqualTo(String value) {
            addCriterion("t_sex =", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotEqualTo(String value) {
            addCriterion("t_sex <>", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexGreaterThan(String value) {
            addCriterion("t_sex >", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexGreaterThanOrEqualTo(String value) {
            addCriterion("t_sex >=", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexLessThan(String value) {
            addCriterion("t_sex <", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexLessThanOrEqualTo(String value) {
            addCriterion("t_sex <=", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexLike(String value) {
            addCriterion("t_sex like", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotLike(String value) {
            addCriterion("t_sex not like", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexIn(List<String> values) {
            addCriterion("t_sex in", values, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotIn(List<String> values) {
            addCriterion("t_sex not in", values, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexBetween(String value1, String value2) {
            addCriterion("t_sex between", value1, value2, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotBetween(String value1, String value2) {
            addCriterion("t_sex not between", value1, value2, "tSex");
            return (Criteria) this;
        }

        public Criteria andTPhoneIsNull() {
            addCriterion("t_phone is null");
            return (Criteria) this;
        }

        public Criteria andTPhoneIsNotNull() {
            addCriterion("t_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTPhoneEqualTo(String value) {
            addCriterion("t_phone =", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneNotEqualTo(String value) {
            addCriterion("t_phone <>", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneGreaterThan(String value) {
            addCriterion("t_phone >", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("t_phone >=", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneLessThan(String value) {
            addCriterion("t_phone <", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneLessThanOrEqualTo(String value) {
            addCriterion("t_phone <=", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneLike(String value) {
            addCriterion("t_phone like", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneNotLike(String value) {
            addCriterion("t_phone not like", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneIn(List<String> values) {
            addCriterion("t_phone in", values, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneNotIn(List<String> values) {
            addCriterion("t_phone not in", values, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneBetween(String value1, String value2) {
            addCriterion("t_phone between", value1, value2, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneNotBetween(String value1, String value2) {
            addCriterion("t_phone not between", value1, value2, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTSchoolIsNull() {
            addCriterion("t_school is null");
            return (Criteria) this;
        }

        public Criteria andTSchoolIsNotNull() {
            addCriterion("t_school is not null");
            return (Criteria) this;
        }

        public Criteria andTSchoolEqualTo(String value) {
            addCriterion("t_school =", value, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolNotEqualTo(String value) {
            addCriterion("t_school <>", value, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolGreaterThan(String value) {
            addCriterion("t_school >", value, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("t_school >=", value, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolLessThan(String value) {
            addCriterion("t_school <", value, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolLessThanOrEqualTo(String value) {
            addCriterion("t_school <=", value, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolLike(String value) {
            addCriterion("t_school like", value, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolNotLike(String value) {
            addCriterion("t_school not like", value, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolIn(List<String> values) {
            addCriterion("t_school in", values, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolNotIn(List<String> values) {
            addCriterion("t_school not in", values, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolBetween(String value1, String value2) {
            addCriterion("t_school between", value1, value2, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTSchoolNotBetween(String value1, String value2) {
            addCriterion("t_school not between", value1, value2, "tSchool");
            return (Criteria) this;
        }

        public Criteria andTEducationIsNull() {
            addCriterion("t_education is null");
            return (Criteria) this;
        }

        public Criteria andTEducationIsNotNull() {
            addCriterion("t_education is not null");
            return (Criteria) this;
        }

        public Criteria andTEducationEqualTo(Integer value) {
            addCriterion("t_education =", value, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationNotEqualTo(Integer value) {
            addCriterion("t_education <>", value, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationGreaterThan(Integer value) {
            addCriterion("t_education >", value, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_education >=", value, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationLessThan(Integer value) {
            addCriterion("t_education <", value, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationLessThanOrEqualTo(Integer value) {
            addCriterion("t_education <=", value, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationIn(List<Integer> values) {
            addCriterion("t_education in", values, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationNotIn(List<Integer> values) {
            addCriterion("t_education not in", values, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationBetween(Integer value1, Integer value2) {
            addCriterion("t_education between", value1, value2, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTEducationNotBetween(Integer value1, Integer value2) {
            addCriterion("t_education not between", value1, value2, "tEducation");
            return (Criteria) this;
        }

        public Criteria andTAddressIsNull() {
            addCriterion("t_address is null");
            return (Criteria) this;
        }

        public Criteria andTAddressIsNotNull() {
            addCriterion("t_address is not null");
            return (Criteria) this;
        }

        public Criteria andTAddressEqualTo(String value) {
            addCriterion("t_address =", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressNotEqualTo(String value) {
            addCriterion("t_address <>", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressGreaterThan(String value) {
            addCriterion("t_address >", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressGreaterThanOrEqualTo(String value) {
            addCriterion("t_address >=", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressLessThan(String value) {
            addCriterion("t_address <", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressLessThanOrEqualTo(String value) {
            addCriterion("t_address <=", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressLike(String value) {
            addCriterion("t_address like", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressNotLike(String value) {
            addCriterion("t_address not like", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressIn(List<String> values) {
            addCriterion("t_address in", values, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressNotIn(List<String> values) {
            addCriterion("t_address not in", values, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressBetween(String value1, String value2) {
            addCriterion("t_address between", value1, value2, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressNotBetween(String value1, String value2) {
            addCriterion("t_address not between", value1, value2, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTDateIsNull() {
            addCriterion("t_date is null");
            return (Criteria) this;
        }

        public Criteria andTDateIsNotNull() {
            addCriterion("t_date is not null");
            return (Criteria) this;
        }

        public Criteria andTDateEqualTo(Date value) {
            addCriterion("t_date =", value, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateNotEqualTo(Date value) {
            addCriterion("t_date <>", value, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateGreaterThan(Date value) {
            addCriterion("t_date >", value, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateGreaterThanOrEqualTo(Date value) {
            addCriterion("t_date >=", value, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateLessThan(Date value) {
            addCriterion("t_date <", value, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateLessThanOrEqualTo(Date value) {
            addCriterion("t_date <=", value, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateIn(List<Date> values) {
            addCriterion("t_date in", values, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateNotIn(List<Date> values) {
            addCriterion("t_date not in", values, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateBetween(Date value1, Date value2) {
            addCriterion("t_date between", value1, value2, "tDate");
            return (Criteria) this;
        }

        public Criteria andTDateNotBetween(Date value1, Date value2) {
            addCriterion("t_date not between", value1, value2, "tDate");
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