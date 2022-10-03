package com.xxz.bean;

import java.util.ArrayList;
import java.util.List;

public class ContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractExample() {
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

        public Criteria andCtContractAmountIsNull() {
            addCriterion("ct_contract_amount is null");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountIsNotNull() {
            addCriterion("ct_contract_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountEqualTo(String value) {
            addCriterion("ct_contract_amount =", value, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountNotEqualTo(String value) {
            addCriterion("ct_contract_amount <>", value, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountGreaterThan(String value) {
            addCriterion("ct_contract_amount >", value, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountGreaterThanOrEqualTo(String value) {
            addCriterion("ct_contract_amount >=", value, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountLessThan(String value) {
            addCriterion("ct_contract_amount <", value, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountLessThanOrEqualTo(String value) {
            addCriterion("ct_contract_amount <=", value, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountLike(String value) {
            addCriterion("ct_contract_amount like", value, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountNotLike(String value) {
            addCriterion("ct_contract_amount not like", value, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountIn(List<String> values) {
            addCriterion("ct_contract_amount in", values, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountNotIn(List<String> values) {
            addCriterion("ct_contract_amount not in", values, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountBetween(String value1, String value2) {
            addCriterion("ct_contract_amount between", value1, value2, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractAmountNotBetween(String value1, String value2) {
            addCriterion("ct_contract_amount not between", value1, value2, "ctContractAmount");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentIsNull() {
            addCriterion("ct_contract_docment is null");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentIsNotNull() {
            addCriterion("ct_contract_docment is not null");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentEqualTo(String value) {
            addCriterion("ct_contract_docment =", value, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentNotEqualTo(String value) {
            addCriterion("ct_contract_docment <>", value, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentGreaterThan(String value) {
            addCriterion("ct_contract_docment >", value, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentGreaterThanOrEqualTo(String value) {
            addCriterion("ct_contract_docment >=", value, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentLessThan(String value) {
            addCriterion("ct_contract_docment <", value, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentLessThanOrEqualTo(String value) {
            addCriterion("ct_contract_docment <=", value, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentLike(String value) {
            addCriterion("ct_contract_docment like", value, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentNotLike(String value) {
            addCriterion("ct_contract_docment not like", value, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentIn(List<String> values) {
            addCriterion("ct_contract_docment in", values, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentNotIn(List<String> values) {
            addCriterion("ct_contract_docment not in", values, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentBetween(String value1, String value2) {
            addCriterion("ct_contract_docment between", value1, value2, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtContractDocmentNotBetween(String value1, String value2) {
            addCriterion("ct_contract_docment not between", value1, value2, "ctContractDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountIsNull() {
            addCriterion("ct_tender_amount is null");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountIsNotNull() {
            addCriterion("ct_tender_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountEqualTo(String value) {
            addCriterion("ct_tender_amount =", value, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountNotEqualTo(String value) {
            addCriterion("ct_tender_amount <>", value, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountGreaterThan(String value) {
            addCriterion("ct_tender_amount >", value, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountGreaterThanOrEqualTo(String value) {
            addCriterion("ct_tender_amount >=", value, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountLessThan(String value) {
            addCriterion("ct_tender_amount <", value, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountLessThanOrEqualTo(String value) {
            addCriterion("ct_tender_amount <=", value, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountLike(String value) {
            addCriterion("ct_tender_amount like", value, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountNotLike(String value) {
            addCriterion("ct_tender_amount not like", value, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountIn(List<String> values) {
            addCriterion("ct_tender_amount in", values, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountNotIn(List<String> values) {
            addCriterion("ct_tender_amount not in", values, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountBetween(String value1, String value2) {
            addCriterion("ct_tender_amount between", value1, value2, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderAmountNotBetween(String value1, String value2) {
            addCriterion("ct_tender_amount not between", value1, value2, "ctTenderAmount");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentIsNull() {
            addCriterion("ct_tender_docment is null");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentIsNotNull() {
            addCriterion("ct_tender_docment is not null");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentEqualTo(String value) {
            addCriterion("ct_tender_docment =", value, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentNotEqualTo(String value) {
            addCriterion("ct_tender_docment <>", value, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentGreaterThan(String value) {
            addCriterion("ct_tender_docment >", value, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentGreaterThanOrEqualTo(String value) {
            addCriterion("ct_tender_docment >=", value, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentLessThan(String value) {
            addCriterion("ct_tender_docment <", value, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentLessThanOrEqualTo(String value) {
            addCriterion("ct_tender_docment <=", value, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentLike(String value) {
            addCriterion("ct_tender_docment like", value, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentNotLike(String value) {
            addCriterion("ct_tender_docment not like", value, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentIn(List<String> values) {
            addCriterion("ct_tender_docment in", values, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentNotIn(List<String> values) {
            addCriterion("ct_tender_docment not in", values, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentBetween(String value1, String value2) {
            addCriterion("ct_tender_docment between", value1, value2, "ctTenderDocment");
            return (Criteria) this;
        }

        public Criteria andCtTenderDocmentNotBetween(String value1, String value2) {
            addCriterion("ct_tender_docment not between", value1, value2, "ctTenderDocment");
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