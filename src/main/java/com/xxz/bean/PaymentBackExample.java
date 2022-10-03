package com.xxz.bean;

import java.util.ArrayList;
import java.util.List;

public class PaymentBackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymentBackExample() {
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

        public Criteria andPbMoneyIsNull() {
            addCriterion("pb_money is null");
            return (Criteria) this;
        }

        public Criteria andPbMoneyIsNotNull() {
            addCriterion("pb_money is not null");
            return (Criteria) this;
        }

        public Criteria andPbMoneyEqualTo(Integer value) {
            addCriterion("pb_money =", value, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyNotEqualTo(Integer value) {
            addCriterion("pb_money <>", value, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyGreaterThan(Integer value) {
            addCriterion("pb_money >", value, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("pb_money >=", value, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyLessThan(Integer value) {
            addCriterion("pb_money <", value, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("pb_money <=", value, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyIn(List<Integer> values) {
            addCriterion("pb_money in", values, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyNotIn(List<Integer> values) {
            addCriterion("pb_money not in", values, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyBetween(Integer value1, Integer value2) {
            addCriterion("pb_money between", value1, value2, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("pb_money not between", value1, value2, "pbMoney");
            return (Criteria) this;
        }

        public Criteria andPbOrderIsNull() {
            addCriterion("pb_order is null");
            return (Criteria) this;
        }

        public Criteria andPbOrderIsNotNull() {
            addCriterion("pb_order is not null");
            return (Criteria) this;
        }

        public Criteria andPbOrderEqualTo(Integer value) {
            addCriterion("pb_order =", value, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderNotEqualTo(Integer value) {
            addCriterion("pb_order <>", value, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderGreaterThan(Integer value) {
            addCriterion("pb_order >", value, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("pb_order >=", value, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderLessThan(Integer value) {
            addCriterion("pb_order <", value, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderLessThanOrEqualTo(Integer value) {
            addCriterion("pb_order <=", value, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderIn(List<Integer> values) {
            addCriterion("pb_order in", values, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderNotIn(List<Integer> values) {
            addCriterion("pb_order not in", values, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderBetween(Integer value1, Integer value2) {
            addCriterion("pb_order between", value1, value2, "pbOrder");
            return (Criteria) this;
        }

        public Criteria andPbOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("pb_order not between", value1, value2, "pbOrder");
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