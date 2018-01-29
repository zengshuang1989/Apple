package edu.zxy.apple.condition.process;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.zxy.apple.condition.managemet.CondProcessorsManager;
import edu.zxy.apple.entity.Account;
import edu.zxy.apple.entity.Record;
import edu.zxy.apple.vo.AcctListCondVO;
import edu.zxy.apple.vo.BaseCondVO;
import edu.zxy.apple.vo.MoneyCondVO;
import edu.zxy.apple.vo.TimeCondVO;

public class AcctListCondProcessor implements CondProcessorInf
{
    @Override
    public void register()
    {
        CondProcessorsManager.getInstance().registerCondProcess("acctList", this);
    }

    @Override
    public Predicate process(CriteriaBuilder crb, Root root, String cond)
    {
        AcctListCondVO acctListCondVO = null;
        try
        {
            acctListCondVO = (AcctListCondVO) new ObjectMapper().readValue(cond, AcctListCondVO.class);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Predicate acctListRestriction = null;

        if (null != acctListCondVO.getAcctIdList() && !acctListCondVO.getAcctIdList().isEmpty())
        {
            Join<Record, Account> flowoutAcctJoin = root.join("flowoutAcct", JoinType.LEFT);
            Join<Record, Account> flowinAcctJoin = root.join("flowinAcct", JoinType.LEFT);
            acctListRestriction = crb.or(flowoutAcctJoin.get("id").in(acctListCondVO.getAcctIdList()),
                    flowinAcctJoin.get("id").in(acctListCondVO.getAcctIdList()));
        }

        return acctListRestriction;
    }

}
