package com.xxz.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
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

        public Criteria andRenameIsNull() {
            addCriterion("`rename` is null");
            return (Criteria) this;
        }

        public Criteria andRenameIsNotNull() {
            addCriterion("`rename` is not null");
            return (Criteria) this;
        }

        public Criteria andRenameEqualTo(String value) {
            addCriterion("`rename` =", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameNotEqualTo(String value) {
            addCriterion("`rename` <>", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameGreaterThan(String value) {
            addCriterion("`rename` >", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameGreaterThanOrEqualTo(String value) {
            addCriterion("`rename` >=", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameLessThan(String value) {
            addCriterion("`rename` <", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameLessThanOrEqualTo(String value) {
            addCriterion("`rename` <=", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameLike(String value) {
            addCriterion("`rename` like", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameNotLike(String value) {
            addCriterion("`rename` not like", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameIn(List<String> values) {
            addCriterion("`rename` in", values, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameNotIn(List<String> values) {
            addCriterion("`rename` not in", values, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameBetween(String value1, String value2) {
            addCriterion("`rename` between", value1, value2, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameNotBetween(String value1, String value2) {
            addCriterion("`rename` not between", value1, value2, "rename");
            return (Criteria) this;
        }

        public Criteria andENameIsNull() {
            addCriterion("e_name is null");
            return (Criteria) this;
        }

        public Criteria andENameIsNotNull() {
            addCriterion("e_name is not null");
            return (Criteria) this;
        }

        public Criteria andENameEqualTo(String value) {
            addCriterion("e_name =", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotEqualTo(String value) {
            addCriterion("e_name <>", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThan(String value) {
            addCriterion("e_name >", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThanOrEqualTo(String value) {
            addCriterion("e_name >=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThan(String value) {
            addCriterion("e_name <", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThanOrEqualTo(String value) {
            addCriterion("e_name <=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLike(String value) {
            addCriterion("e_name like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotLike(String value) {
            addCriterion("e_name not like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameIn(List<String> values) {
            addCriterion("e_name in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotIn(List<String> values) {
            addCriterion("e_name not in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameBetween(String value1, String value2) {
            addCriterion("e_name between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotBetween(String value1, String value2) {
            addCriterion("e_name not between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andEPwdIsNull() {
            addCriterion("e_pwd is null");
            return (Criteria) this;
        }

        public Criteria andEPwdIsNotNull() {
            addCriterion("e_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andEPwdEqualTo(String value) {
            addCriterion("e_pwd =", value, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdNotEqualTo(String value) {
            addCriterion("e_pwd <>", value, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdGreaterThan(String value) {
            addCriterion("e_pwd >", value, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdGreaterThanOrEqualTo(String value) {
            addCriterion("e_pwd >=", value, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdLessThan(String value) {
            addCriterion("e_pwd <", value, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdLessThanOrEqualTo(String value) {
            addCriterion("e_pwd <=", value, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdLike(String value) {
            addCriterion("e_pwd like", value, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdNotLike(String value) {
            addCriterion("e_pwd not like", value, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdIn(List<String> values) {
            addCriterion("e_pwd in", values, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdNotIn(List<String> values) {
            addCriterion("e_pwd not in", values, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdBetween(String value1, String value2) {
            addCriterion("e_pwd between", value1, value2, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEPwdNotBetween(String value1, String value2) {
            addCriterion("e_pwd not between", value1, value2, "ePwd");
            return (Criteria) this;
        }

        public Criteria andEBirthdayIsNull() {
            addCriterion("e_birthday is null");
            return (Criteria) this;
        }

        public Criteria andEBirthdayIsNotNull() {
            addCriterion("e_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andEBirthdayEqualTo(String value) {
            addCriterion("e_birthday =", value, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayNotEqualTo(String value) {
            addCriterion("e_birthday <>", value, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayGreaterThan(String value) {
            addCriterion("e_birthday >", value, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("e_birthday >=", value, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayLessThan(String value) {
            addCriterion("e_birthday <", value, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayLessThanOrEqualTo(String value) {
            addCriterion("e_birthday <=", value, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayLike(String value) {
            addCriterion("e_birthday like", value, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayNotLike(String value) {
            addCriterion("e_birthday not like", value, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayIn(List<String> values) {
            addCriterion("e_birthday in", values, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayNotIn(List<String> values) {
            addCriterion("e_birthday not in", values, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayBetween(String value1, String value2) {
            addCriterion("e_birthday between", value1, value2, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andEBirthdayNotBetween(String value1, String value2) {
            addCriterion("e_birthday not between", value1, value2, "eBirthday");
            return (Criteria) this;
        }

        public Criteria andESchoolIsNull() {
            addCriterion("e_school is null");
            return (Criteria) this;
        }

        public Criteria andESchoolIsNotNull() {
            addCriterion("e_school is not null");
            return (Criteria) this;
        }

        public Criteria andESchoolEqualTo(String value) {
            addCriterion("e_school =", value, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolNotEqualTo(String value) {
            addCriterion("e_school <>", value, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolGreaterThan(String value) {
            addCriterion("e_school >", value, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolGreaterThanOrEqualTo(String value) {
            addCriterion("e_school >=", value, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolLessThan(String value) {
            addCriterion("e_school <", value, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolLessThanOrEqualTo(String value) {
            addCriterion("e_school <=", value, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolLike(String value) {
            addCriterion("e_school like", value, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolNotLike(String value) {
            addCriterion("e_school not like", value, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolIn(List<String> values) {
            addCriterion("e_school in", values, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolNotIn(List<String> values) {
            addCriterion("e_school not in", values, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolBetween(String value1, String value2) {
            addCriterion("e_school between", value1, value2, "eSchool");
            return (Criteria) this;
        }

        public Criteria andESchoolNotBetween(String value1, String value2) {
            addCriterion("e_school not between", value1, value2, "eSchool");
            return (Criteria) this;
        }

        public Criteria andEJobIsNull() {
            addCriterion("e_job is null");
            return (Criteria) this;
        }

        public Criteria andEJobIsNotNull() {
            addCriterion("e_job is not null");
            return (Criteria) this;
        }

        public Criteria andEJobEqualTo(String value) {
            addCriterion("e_job =", value, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobNotEqualTo(String value) {
            addCriterion("e_job <>", value, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobGreaterThan(String value) {
            addCriterion("e_job >", value, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobGreaterThanOrEqualTo(String value) {
            addCriterion("e_job >=", value, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobLessThan(String value) {
            addCriterion("e_job <", value, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobLessThanOrEqualTo(String value) {
            addCriterion("e_job <=", value, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobLike(String value) {
            addCriterion("e_job like", value, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobNotLike(String value) {
            addCriterion("e_job not like", value, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobIn(List<String> values) {
            addCriterion("e_job in", values, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobNotIn(List<String> values) {
            addCriterion("e_job not in", values, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobBetween(String value1, String value2) {
            addCriterion("e_job between", value1, value2, "eJob");
            return (Criteria) this;
        }

        public Criteria andEJobNotBetween(String value1, String value2) {
            addCriterion("e_job not between", value1, value2, "eJob");
            return (Criteria) this;
        }

        public Criteria andEStartTimeIsNull() {
            addCriterion("e_start_time is null");
            return (Criteria) this;
        }

        public Criteria andEStartTimeIsNotNull() {
            addCriterion("e_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andEStartTimeEqualTo(String value) {
            addCriterion("e_start_time =", value, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeNotEqualTo(String value) {
            addCriterion("e_start_time <>", value, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeGreaterThan(String value) {
            addCriterion("e_start_time >", value, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("e_start_time >=", value, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeLessThan(String value) {
            addCriterion("e_start_time <", value, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeLessThanOrEqualTo(String value) {
            addCriterion("e_start_time <=", value, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeLike(String value) {
            addCriterion("e_start_time like", value, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeNotLike(String value) {
            addCriterion("e_start_time not like", value, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeIn(List<String> values) {
            addCriterion("e_start_time in", values, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeNotIn(List<String> values) {
            addCriterion("e_start_time not in", values, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeBetween(String value1, String value2) {
            addCriterion("e_start_time between", value1, value2, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andEStartTimeNotBetween(String value1, String value2) {
            addCriterion("e_start_time not between", value1, value2, "eStartTime");
            return (Criteria) this;
        }

        public Criteria andESocialPositionIsNull() {
            addCriterion("e_social_position is null");
            return (Criteria) this;
        }

        public Criteria andESocialPositionIsNotNull() {
            addCriterion("e_social_position is not null");
            return (Criteria) this;
        }

        public Criteria andESocialPositionEqualTo(String value) {
            addCriterion("e_social_position =", value, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionNotEqualTo(String value) {
            addCriterion("e_social_position <>", value, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionGreaterThan(String value) {
            addCriterion("e_social_position >", value, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionGreaterThanOrEqualTo(String value) {
            addCriterion("e_social_position >=", value, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionLessThan(String value) {
            addCriterion("e_social_position <", value, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionLessThanOrEqualTo(String value) {
            addCriterion("e_social_position <=", value, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionLike(String value) {
            addCriterion("e_social_position like", value, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionNotLike(String value) {
            addCriterion("e_social_position not like", value, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionIn(List<String> values) {
            addCriterion("e_social_position in", values, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionNotIn(List<String> values) {
            addCriterion("e_social_position not in", values, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionBetween(String value1, String value2) {
            addCriterion("e_social_position between", value1, value2, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andESocialPositionNotBetween(String value1, String value2) {
            addCriterion("e_social_position not between", value1, value2, "eSocialPosition");
            return (Criteria) this;
        }

        public Criteria andEHonorIsNull() {
            addCriterion("e_honor is null");
            return (Criteria) this;
        }

        public Criteria andEHonorIsNotNull() {
            addCriterion("e_honor is not null");
            return (Criteria) this;
        }

        public Criteria andEHonorEqualTo(String value) {
            addCriterion("e_honor =", value, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorNotEqualTo(String value) {
            addCriterion("e_honor <>", value, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorGreaterThan(String value) {
            addCriterion("e_honor >", value, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorGreaterThanOrEqualTo(String value) {
            addCriterion("e_honor >=", value, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorLessThan(String value) {
            addCriterion("e_honor <", value, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorLessThanOrEqualTo(String value) {
            addCriterion("e_honor <=", value, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorLike(String value) {
            addCriterion("e_honor like", value, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorNotLike(String value) {
            addCriterion("e_honor not like", value, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorIn(List<String> values) {
            addCriterion("e_honor in", values, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorNotIn(List<String> values) {
            addCriterion("e_honor not in", values, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorBetween(String value1, String value2) {
            addCriterion("e_honor between", value1, value2, "eHonor");
            return (Criteria) this;
        }

        public Criteria andEHonorNotBetween(String value1, String value2) {
            addCriterion("e_honor not between", value1, value2, "eHonor");
            return (Criteria) this;
        }

        public Criteria andERemarkIsNull() {
            addCriterion("e_remark is null");
            return (Criteria) this;
        }

        public Criteria andERemarkIsNotNull() {
            addCriterion("e_remark is not null");
            return (Criteria) this;
        }

        public Criteria andERemarkEqualTo(String value) {
            addCriterion("e_remark =", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkNotEqualTo(String value) {
            addCriterion("e_remark <>", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkGreaterThan(String value) {
            addCriterion("e_remark >", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkGreaterThanOrEqualTo(String value) {
            addCriterion("e_remark >=", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkLessThan(String value) {
            addCriterion("e_remark <", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkLessThanOrEqualTo(String value) {
            addCriterion("e_remark <=", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkLike(String value) {
            addCriterion("e_remark like", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkNotLike(String value) {
            addCriterion("e_remark not like", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkIn(List<String> values) {
            addCriterion("e_remark in", values, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkNotIn(List<String> values) {
            addCriterion("e_remark not in", values, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkBetween(String value1, String value2) {
            addCriterion("e_remark between", value1, value2, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkNotBetween(String value1, String value2) {
            addCriterion("e_remark not between", value1, value2, "eRemark");
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