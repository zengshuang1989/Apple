package edu.zxy.apple.condition.process;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import edu.zxy.apple.condition.manage.CondProcessManage;
import edu.zxy.apple.condition.vo.BaseCondVO;
import edu.zxy.apple.condition.vo.MoneyCondVO;

public class MoneyCondProcessImpl implements CondProcessInf
{

    @Override
    public void registerProcess()
    {
        CondProcessManage.getInstance().registerCondProcess("money", this);
    }

    @Override
    public Predicate process(CriteriaBuilder crb, Root root, BaseCondVO cond)
    {
        MoneyCondVO moneyCondVO = (MoneyCondVO) cond;
        // 金额
        Predicate moneyRestriction = null;
        if (null != moneyCondVO.getMinMoney() && null != moneyCondVO.getMaxMoney())
        {
            moneyRestriction = crb.between(root.get("money"), moneyCondVO.getMinMoney(), moneyCondVO.getMaxMoney());
        } else if (null != moneyCondVO.getMinMoney() && null == moneyCondVO.getMaxMoney())
        {
            moneyRestriction = crb.greaterThanOrEqualTo(root.get("money"), moneyCondVO.getMinMoney());
        } else if (null == moneyCondVO.getMinMoney() && null != moneyCondVO.getMaxMoney())
        {
            moneyRestriction = crb.lessThanOrEqualTo(root.get("money"), moneyCondVO.getMaxMoney());
        }
        return moneyRestriction;
    }

}
