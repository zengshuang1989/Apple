package edu.zxy.apple.condition.process;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import edu.zxy.apple.condition.managemet.CondProcessorsManager;
import edu.zxy.apple.vo.BaseCondVO;
import edu.zxy.apple.vo.MoneyCondVO;

public class MoneyCondProcessor implements CondProcessorInf
{

    @Override
    public void register()
    {
        CondProcessorsManager.getInstance().registerCondProcess("money", this);
    }

    @Override
    public Predicate process(CriteriaBuilder crb, Root root, BaseCondVO cond)
    {
        MoneyCondVO moneyCondVO = (MoneyCondVO) cond;
        // 金额
        Predicate moneyRestriction = null;
        if (0D != moneyCondVO.getMaxMoney())
        {
            moneyRestriction = crb.between(root.get("money"), moneyCondVO.getMinMoney(), moneyCondVO.getMaxMoney());
        } else if (0D == moneyCondVO.getMaxMoney())
        {
            moneyRestriction = crb.greaterThanOrEqualTo(root.get("money"), moneyCondVO.getMinMoney());
        }
        return moneyRestriction;
    }

}
