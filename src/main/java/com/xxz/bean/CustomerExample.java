package com.xxz.bean;

import java.util.ArrayList;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCRenameIsNull() {
            addCriterion("c_rename is null");
            return (Criteria) this;
        }

        public Criteria andCRenameIsNotNull() {
            addCriterion("c_rename is not null");
            return (Criteria) this;
        }

        public Criteria andCRenameEqualTo(String value) {
            addCriterion("c_rename =", value, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameNotEqualTo(String value) {
            addCriterion("c_rename <>", value, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameGreaterThan(String value) {
            addCriterion("c_rename >", value, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameGreaterThanOrEqualTo(String value) {
            addCriterion("c_rename >=", value, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameLessThan(String value) {
            addCriterion("c_rename <", value, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameLessThanOrEqualTo(String value) {
            addCriterion("c_rename <=", value, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameLike(String value) {
            addCriterion("c_rename like", value, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameNotLike(String value) {
            addCriterion("c_rename not like", value, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameIn(List<String> values) {
            addCriterion("c_rename in", values, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameNotIn(List<String> values) {
            addCriterion("c_rename not in", values, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameBetween(String value1, String value2) {
            addCriterion("c_rename between", value1, value2, "cRename");
            return (Criteria) this;
        }

        public Criteria andCRenameNotBetween(String value1, String value2) {
            addCriterion("c_rename not between", value1, value2, "cRename");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCDepartIsNull() {
            addCriterion("c_depart is null");
            return (Criteria) this;
        }

        public Criteria andCDepartIsNotNull() {
            addCriterion("c_depart is not null");
            return (Criteria) this;
        }

        public Criteria andCDepartEqualTo(String value) {
            addCriterion("c_depart =", value, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartNotEqualTo(String value) {
            addCriterion("c_depart <>", value, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartGreaterThan(String value) {
            addCriterion("c_depart >", value, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartGreaterThanOrEqualTo(String value) {
            addCriterion("c_depart >=", value, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartLessThan(String value) {
            addCriterion("c_depart <", value, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartLessThanOrEqualTo(String value) {
            addCriterion("c_depart <=", value, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartLike(String value) {
            addCriterion("c_depart like", value, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartNotLike(String value) {
            addCriterion("c_depart not like", value, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartIn(List<String> values) {
            addCriterion("c_depart in", values, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartNotIn(List<String> values) {
            addCriterion("c_depart not in", values, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartBetween(String value1, String value2) {
            addCriterion("c_depart between", value1, value2, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCDepartNotBetween(String value1, String value2) {
            addCriterion("c_depart not between", value1, value2, "cDepart");
            return (Criteria) this;
        }

        public Criteria andCJobIsNull() {
            addCriterion("c_job is null");
            return (Criteria) this;
        }

        public Criteria andCJobIsNotNull() {
            addCriterion("c_job is not null");
            return (Criteria) this;
        }

        public Criteria andCJobEqualTo(String value) {
            addCriterion("c_job =", value, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobNotEqualTo(String value) {
            addCriterion("c_job <>", value, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobGreaterThan(String value) {
            addCriterion("c_job >", value, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobGreaterThanOrEqualTo(String value) {
            addCriterion("c_job >=", value, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobLessThan(String value) {
            addCriterion("c_job <", value, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobLessThanOrEqualTo(String value) {
            addCriterion("c_job <=", value, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobLike(String value) {
            addCriterion("c_job like", value, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobNotLike(String value) {
            addCriterion("c_job not like", value, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobIn(List<String> values) {
            addCriterion("c_job in", values, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobNotIn(List<String> values) {
            addCriterion("c_job not in", values, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobBetween(String value1, String value2) {
            addCriterion("c_job between", value1, value2, "cJob");
            return (Criteria) this;
        }

        public Criteria andCJobNotBetween(String value1, String value2) {
            addCriterion("c_job not between", value1, value2, "cJob");
            return (Criteria) this;
        }

        public Criteria andCTeleIsNull() {
            addCriterion("c_tele is null");
            return (Criteria) this;
        }

        public Criteria andCTeleIsNotNull() {
            addCriterion("c_tele is not null");
            return (Criteria) this;
        }

        public Criteria andCTeleEqualTo(String value) {
            addCriterion("c_tele =", value, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleNotEqualTo(String value) {
            addCriterion("c_tele <>", value, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleGreaterThan(String value) {
            addCriterion("c_tele >", value, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleGreaterThanOrEqualTo(String value) {
            addCriterion("c_tele >=", value, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleLessThan(String value) {
            addCriterion("c_tele <", value, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleLessThanOrEqualTo(String value) {
            addCriterion("c_tele <=", value, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleLike(String value) {
            addCriterion("c_tele like", value, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleNotLike(String value) {
            addCriterion("c_tele not like", value, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleIn(List<String> values) {
            addCriterion("c_tele in", values, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleNotIn(List<String> values) {
            addCriterion("c_tele not in", values, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleBetween(String value1, String value2) {
            addCriterion("c_tele between", value1, value2, "cTele");
            return (Criteria) this;
        }

        public Criteria andCTeleNotBetween(String value1, String value2) {
            addCriterion("c_tele not between", value1, value2, "cTele");
            return (Criteria) this;
        }

        public Criteria andCPostIsNull() {
            addCriterion("c_post is null");
            return (Criteria) this;
        }

        public Criteria andCPostIsNotNull() {
            addCriterion("c_post is not null");
            return (Criteria) this;
        }

        public Criteria andCPostEqualTo(String value) {
            addCriterion("c_post =", value, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostNotEqualTo(String value) {
            addCriterion("c_post <>", value, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostGreaterThan(String value) {
            addCriterion("c_post >", value, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostGreaterThanOrEqualTo(String value) {
            addCriterion("c_post >=", value, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostLessThan(String value) {
            addCriterion("c_post <", value, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostLessThanOrEqualTo(String value) {
            addCriterion("c_post <=", value, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostLike(String value) {
            addCriterion("c_post like", value, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostNotLike(String value) {
            addCriterion("c_post not like", value, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostIn(List<String> values) {
            addCriterion("c_post in", values, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostNotIn(List<String> values) {
            addCriterion("c_post not in", values, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostBetween(String value1, String value2) {
            addCriterion("c_post between", value1, value2, "cPost");
            return (Criteria) this;
        }

        public Criteria andCPostNotBetween(String value1, String value2) {
            addCriterion("c_post not between", value1, value2, "cPost");
            return (Criteria) this;
        }

        public Criteria andCHobbyIsNull() {
            addCriterion("c_hobby is null");
            return (Criteria) this;
        }

        public Criteria andCHobbyIsNotNull() {
            addCriterion("c_hobby is not null");
            return (Criteria) this;
        }

        public Criteria andCHobbyEqualTo(String value) {
            addCriterion("c_hobby =", value, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyNotEqualTo(String value) {
            addCriterion("c_hobby <>", value, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyGreaterThan(String value) {
            addCriterion("c_hobby >", value, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("c_hobby >=", value, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyLessThan(String value) {
            addCriterion("c_hobby <", value, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyLessThanOrEqualTo(String value) {
            addCriterion("c_hobby <=", value, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyLike(String value) {
            addCriterion("c_hobby like", value, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyNotLike(String value) {
            addCriterion("c_hobby not like", value, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyIn(List<String> values) {
            addCriterion("c_hobby in", values, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyNotIn(List<String> values) {
            addCriterion("c_hobby not in", values, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyBetween(String value1, String value2) {
            addCriterion("c_hobby between", value1, value2, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCHobbyNotBetween(String value1, String value2) {
            addCriterion("c_hobby not between", value1, value2, "cHobby");
            return (Criteria) this;
        }

        public Criteria andCRemarkIsNull() {
            addCriterion("c_remark is null");
            return (Criteria) this;
        }

        public Criteria andCRemarkIsNotNull() {
            addCriterion("c_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCRemarkEqualTo(String value) {
            addCriterion("c_remark =", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotEqualTo(String value) {
            addCriterion("c_remark <>", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkGreaterThan(String value) {
            addCriterion("c_remark >", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("c_remark >=", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLessThan(String value) {
            addCriterion("c_remark <", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLessThanOrEqualTo(String value) {
            addCriterion("c_remark <=", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLike(String value) {
            addCriterion("c_remark like", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotLike(String value) {
            addCriterion("c_remark not like", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkIn(List<String> values) {
            addCriterion("c_remark in", values, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotIn(List<String> values) {
            addCriterion("c_remark not in", values, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkBetween(String value1, String value2) {
            addCriterion("c_remark between", value1, value2, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotBetween(String value1, String value2) {
            addCriterion("c_remark not between", value1, value2, "cRemark");
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