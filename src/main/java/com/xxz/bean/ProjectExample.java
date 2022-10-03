package com.xxz.bean;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPMoenyIsNull() {
            addCriterion("p_moeny is null");
            return (Criteria) this;
        }

        public Criteria andPMoenyIsNotNull() {
            addCriterion("p_moeny is not null");
            return (Criteria) this;
        }

        public Criteria andPMoenyEqualTo(String value) {
            addCriterion("p_moeny =", value, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyNotEqualTo(String value) {
            addCriterion("p_moeny <>", value, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyGreaterThan(String value) {
            addCriterion("p_moeny >", value, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyGreaterThanOrEqualTo(String value) {
            addCriterion("p_moeny >=", value, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyLessThan(String value) {
            addCriterion("p_moeny <", value, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyLessThanOrEqualTo(String value) {
            addCriterion("p_moeny <=", value, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyLike(String value) {
            addCriterion("p_moeny like", value, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyNotLike(String value) {
            addCriterion("p_moeny not like", value, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyIn(List<String> values) {
            addCriterion("p_moeny in", values, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyNotIn(List<String> values) {
            addCriterion("p_moeny not in", values, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyBetween(String value1, String value2) {
            addCriterion("p_moeny between", value1, value2, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPMoenyNotBetween(String value1, String value2) {
            addCriterion("p_moeny not between", value1, value2, "pMoeny");
            return (Criteria) this;
        }

        public Criteria andPProgressIsNull() {
            addCriterion("p_progress is null");
            return (Criteria) this;
        }

        public Criteria andPProgressIsNotNull() {
            addCriterion("p_progress is not null");
            return (Criteria) this;
        }

        public Criteria andPProgressEqualTo(String value) {
            addCriterion("p_progress =", value, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressNotEqualTo(String value) {
            addCriterion("p_progress <>", value, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressGreaterThan(String value) {
            addCriterion("p_progress >", value, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressGreaterThanOrEqualTo(String value) {
            addCriterion("p_progress >=", value, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressLessThan(String value) {
            addCriterion("p_progress <", value, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressLessThanOrEqualTo(String value) {
            addCriterion("p_progress <=", value, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressLike(String value) {
            addCriterion("p_progress like", value, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressNotLike(String value) {
            addCriterion("p_progress not like", value, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressIn(List<String> values) {
            addCriterion("p_progress in", values, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressNotIn(List<String> values) {
            addCriterion("p_progress not in", values, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressBetween(String value1, String value2) {
            addCriterion("p_progress between", value1, value2, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPProgressNotBetween(String value1, String value2) {
            addCriterion("p_progress not between", value1, value2, "pProgress");
            return (Criteria) this;
        }

        public Criteria andPOwnerIsNull() {
            addCriterion("p_owner is null");
            return (Criteria) this;
        }

        public Criteria andPOwnerIsNotNull() {
            addCriterion("p_owner is not null");
            return (Criteria) this;
        }

        public Criteria andPOwnerEqualTo(String value) {
            addCriterion("p_owner =", value, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerNotEqualTo(String value) {
            addCriterion("p_owner <>", value, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerGreaterThan(String value) {
            addCriterion("p_owner >", value, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("p_owner >=", value, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerLessThan(String value) {
            addCriterion("p_owner <", value, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerLessThanOrEqualTo(String value) {
            addCriterion("p_owner <=", value, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerLike(String value) {
            addCriterion("p_owner like", value, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerNotLike(String value) {
            addCriterion("p_owner not like", value, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerIn(List<String> values) {
            addCriterion("p_owner in", values, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerNotIn(List<String> values) {
            addCriterion("p_owner not in", values, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerBetween(String value1, String value2) {
            addCriterion("p_owner between", value1, value2, "pOwner");
            return (Criteria) this;
        }

        public Criteria andPOwnerNotBetween(String value1, String value2) {
            addCriterion("p_owner not between", value1, value2, "pOwner");
            return (Criteria) this;
        }

        public Criteria andCpIdIsNull() {
            addCriterion("cp_id is null");
            return (Criteria) this;
        }

        public Criteria andCpIdIsNotNull() {
            addCriterion("cp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCpIdEqualTo(Integer value) {
            addCriterion("cp_id =", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotEqualTo(Integer value) {
            addCriterion("cp_id <>", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdGreaterThan(Integer value) {
            addCriterion("cp_id >", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cp_id >=", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdLessThan(Integer value) {
            addCriterion("cp_id <", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdLessThanOrEqualTo(Integer value) {
            addCriterion("cp_id <=", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdIn(List<Integer> values) {
            addCriterion("cp_id in", values, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotIn(List<Integer> values) {
            addCriterion("cp_id not in", values, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdBetween(Integer value1, Integer value2) {
            addCriterion("cp_id between", value1, value2, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cp_id not between", value1, value2, "cpId");
            return (Criteria) this;
        }

        public Criteria andPbIdIsNull() {
            addCriterion("pb_id is null");
            return (Criteria) this;
        }

        public Criteria andPbIdIsNotNull() {
            addCriterion("pb_id is not null");
            return (Criteria) this;
        }

        public Criteria andPbIdEqualTo(Integer value) {
            addCriterion("pb_id =", value, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdNotEqualTo(Integer value) {
            addCriterion("pb_id <>", value, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdGreaterThan(Integer value) {
            addCriterion("pb_id >", value, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pb_id >=", value, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdLessThan(Integer value) {
            addCriterion("pb_id <", value, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdLessThanOrEqualTo(Integer value) {
            addCriterion("pb_id <=", value, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdIn(List<Integer> values) {
            addCriterion("pb_id in", values, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdNotIn(List<Integer> values) {
            addCriterion("pb_id not in", values, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdBetween(Integer value1, Integer value2) {
            addCriterion("pb_id between", value1, value2, "pbId");
            return (Criteria) this;
        }

        public Criteria andPbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pb_id not between", value1, value2, "pbId");
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