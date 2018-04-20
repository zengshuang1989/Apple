package edu.zxy.apple.condition.process;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public Predicate process(CriteriaBuilder crb, Root root, String cond)
    {
        MoneyCondVO moneyCondVO = null;
        try
        {
            moneyCondVO = (MoneyCondVO) new ObjectMapper().readValue(cond, MoneyCondVO.class);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
