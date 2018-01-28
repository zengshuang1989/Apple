package edu.zxy.apple.vo;

import edu.zxy.apple.enums.CategoryType;

public class CategoryTypeCondVO extends BaseCondVO
{
    private CategoryType categoryType;

    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType)
    {
        this.categoryType = categoryType;
    }

}
