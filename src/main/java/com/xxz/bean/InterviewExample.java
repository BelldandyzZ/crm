package com.xxz.bean;

import java.util.ArrayList;
import java.util.List;

public class InterviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InterviewExample() {
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

        public Criteria andIIdIsNull() {
            addCriterion("i_id is null");
            return (Criteria) this;
        }

        public Criteria andIIdIsNotNull() {
            addCriterion("i_id is not null");
            return (Criteria) this;
        }

        public Criteria andIIdEqualTo(Integer value) {
            addCriterion("i_id =", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotEqualTo(Integer value) {
            addCriterion("i_id <>", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThan(Integer value) {
            addCriterion("i_id >", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_id >=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThan(Integer value) {
            addCriterion("i_id <", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThanOrEqualTo(Integer value) {
            addCriterion("i_id <=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdIn(List<Integer> values) {
            addCriterion("i_id in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotIn(List<Integer> values) {
            addCriterion("i_id not in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdBetween(Integer value1, Integer value2) {
            addCriterion("i_id between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotBetween(Integer value1, Integer value2) {
            addCriterion("i_id not between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andICompanyIsNull() {
            addCriterion("i_company is null");
            return (Criteria) this;
        }

        public Criteria andICompanyIsNotNull() {
            addCriterion("i_company is not null");
            return (Criteria) this;
        }

        public Criteria andICompanyEqualTo(String value) {
            addCriterion("i_company =", value, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyNotEqualTo(String value) {
            addCriterion("i_company <>", value, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyGreaterThan(String value) {
            addCriterion("i_company >", value, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyGreaterThanOrEqualTo(String value) {
            addCriterion("i_company >=", value, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyLessThan(String value) {
            addCriterion("i_company <", value, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyLessThanOrEqualTo(String value) {
            addCriterion("i_company <=", value, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyLike(String value) {
            addCriterion("i_company like", value, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyNotLike(String value) {
            addCriterion("i_company not like", value, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyIn(List<String> values) {
            addCriterion("i_company in", values, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyNotIn(List<String> values) {
            addCriterion("i_company not in", values, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyBetween(String value1, String value2) {
            addCriterion("i_company between", value1, value2, "iCompany");
            return (Criteria) this;
        }

        public Criteria andICompanyNotBetween(String value1, String value2) {
            addCriterion("i_company not between", value1, value2, "iCompany");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeIsNull() {
            addCriterion("i_visit_time is null");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeIsNotNull() {
            addCriterion("i_visit_time is not null");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeEqualTo(String value) {
            addCriterion("i_visit_time =", value, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeNotEqualTo(String value) {
            addCriterion("i_visit_time <>", value, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeGreaterThan(String value) {
            addCriterion("i_visit_time >", value, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeGreaterThanOrEqualTo(String value) {
            addCriterion("i_visit_time >=", value, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeLessThan(String value) {
            addCriterion("i_visit_time <", value, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeLessThanOrEqualTo(String value) {
            addCriterion("i_visit_time <=", value, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeLike(String value) {
            addCriterion("i_visit_time like", value, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeNotLike(String value) {
            addCriterion("i_visit_time not like", value, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeIn(List<String> values) {
            addCriterion("i_visit_time in", values, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeNotIn(List<String> values) {
            addCriterion("i_visit_time not in", values, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeBetween(String value1, String value2) {
            addCriterion("i_visit_time between", value1, value2, "iVisitTime");
            return (Criteria) this;
        }

        public Criteria andIVisitTimeNotBetween(String value1, String value2) {
            addCriterion("i_visit_time not between", value1, value2, "iVisitTime");
            return (Criteria) this;
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

        public Criteria andEIdIsNull() {
            addCriterion("e_id is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("e_id is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(Integer value) {
            addCriterion("e_id =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(Integer value) {
            addCriterion("e_id <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(Integer value) {
            addCriterion("e_id >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_id >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(Integer value) {
            addCriterion("e_id <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(Integer value) {
            addCriterion("e_id <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<Integer> values) {
            addCriterion("e_id in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<Integer> values) {
            addCriterion("e_id not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(Integer value1, Integer value2) {
            addCriterion("e_id between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(Integer value1, Integer value2) {
            addCriterion("e_id not between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andIOthersIsNull() {
            addCriterion("i_others is null");
            return (Criteria) this;
        }

        public Criteria andIOthersIsNotNull() {
            addCriterion("i_others is not null");
            return (Criteria) this;
        }

        public Criteria andIOthersEqualTo(String value) {
            addCriterion("i_others =", value, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersNotEqualTo(String value) {
            addCriterion("i_others <>", value, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersGreaterThan(String value) {
            addCriterion("i_others >", value, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersGreaterThanOrEqualTo(String value) {
            addCriterion("i_others >=", value, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersLessThan(String value) {
            addCriterion("i_others <", value, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersLessThanOrEqualTo(String value) {
            addCriterion("i_others <=", value, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersLike(String value) {
            addCriterion("i_others like", value, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersNotLike(String value) {
            addCriterion("i_others not like", value, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersIn(List<String> values) {
            addCriterion("i_others in", values, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersNotIn(List<String> values) {
            addCriterion("i_others not in", values, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersBetween(String value1, String value2) {
            addCriterion("i_others between", value1, value2, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIOthersNotBetween(String value1, String value2) {
            addCriterion("i_others not between", value1, value2, "iOthers");
            return (Criteria) this;
        }

        public Criteria andIContentIsNull() {
            addCriterion("i_content is null");
            return (Criteria) this;
        }

        public Criteria andIContentIsNotNull() {
            addCriterion("i_content is not null");
            return (Criteria) this;
        }

        public Criteria andIContentEqualTo(String value) {
            addCriterion("i_content =", value, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentNotEqualTo(String value) {
            addCriterion("i_content <>", value, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentGreaterThan(String value) {
            addCriterion("i_content >", value, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentGreaterThanOrEqualTo(String value) {
            addCriterion("i_content >=", value, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentLessThan(String value) {
            addCriterion("i_content <", value, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentLessThanOrEqualTo(String value) {
            addCriterion("i_content <=", value, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentLike(String value) {
            addCriterion("i_content like", value, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentNotLike(String value) {
            addCriterion("i_content not like", value, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentIn(List<String> values) {
            addCriterion("i_content in", values, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentNotIn(List<String> values) {
            addCriterion("i_content not in", values, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentBetween(String value1, String value2) {
            addCriterion("i_content between", value1, value2, "iContent");
            return (Criteria) this;
        }

        public Criteria andIContentNotBetween(String value1, String value2) {
            addCriterion("i_content not between", value1, value2, "iContent");
            return (Criteria) this;
        }

        public Criteria andINextIsNull() {
            addCriterion("i_next is null");
            return (Criteria) this;
        }

        public Criteria andINextIsNotNull() {
            addCriterion("i_next is not null");
            return (Criteria) this;
        }

        public Criteria andINextEqualTo(String value) {
            addCriterion("i_next =", value, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextNotEqualTo(String value) {
            addCriterion("i_next <>", value, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextGreaterThan(String value) {
            addCriterion("i_next >", value, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextGreaterThanOrEqualTo(String value) {
            addCriterion("i_next >=", value, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextLessThan(String value) {
            addCriterion("i_next <", value, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextLessThanOrEqualTo(String value) {
            addCriterion("i_next <=", value, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextLike(String value) {
            addCriterion("i_next like", value, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextNotLike(String value) {
            addCriterion("i_next not like", value, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextIn(List<String> values) {
            addCriterion("i_next in", values, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextNotIn(List<String> values) {
            addCriterion("i_next not in", values, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextBetween(String value1, String value2) {
            addCriterion("i_next between", value1, value2, "iNext");
            return (Criteria) this;
        }

        public Criteria andINextNotBetween(String value1, String value2) {
            addCriterion("i_next not between", value1, value2, "iNext");
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