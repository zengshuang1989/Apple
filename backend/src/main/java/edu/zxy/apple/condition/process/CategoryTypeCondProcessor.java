package edu.zxy.apple.condition.process;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.zxy.apple.condition.managemet.CondProcessorsManager;
import edu.zxy.apple.entity.Category;
import edu.zxy.apple.entity.Record;
import edu.zxy.apple.vo.BaseCondVO;
import edu.zxy.apple.vo.CategoryTypeCondVO;
import edu.zxy.apple.vo.MoneyCondVO;
import edu.zxy.apple.vo.TimeCondVO;

public class CategoryTypeCondProcessor implements CondProcessorInf
{
    @Override
    public void register()
    {
        CondProcessorsManager.getInstance().registerCondProcess("categoryType", this);
    }

    @Override
    public Predicate process(CriteriaBuilder crb, Root root, String cond)
    {
        CategoryTypeCondVO categoryTypeCondVO = null;
        try
        {
            categoryTypeCondVO = (CategoryTypeCondVO) new ObjectMapper().readValue(cond, CategoryTypeCondVO.class);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Predicate categoryTypeRestriction = null;

        if (null != categoryTypeCondVO.getCategoryType())
        {
            Join<Record, Category> ownCategoryJoin = root.join("ownCategory", JoinType.LEFT);
            categoryTypeRestriction = crb.equal(ownCategoryJoin.get("type"), categoryTypeCondVO.getCategoryType());
        }

        return categoryTypeRestriction;
    }

}
