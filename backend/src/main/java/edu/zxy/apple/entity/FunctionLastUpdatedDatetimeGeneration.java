package edu.zxy.apple.entity;

import org.hibernate.tuple.AnnotationValueGeneration;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGenerator;

public class FunctionLastUpdatedDatetimeGeneration implements AnnotationValueGeneration<FunctionLastUpdatedDatetime>
{

    /**
     * ���к�
     */
    private static final long serialVersionUID = 1542971977727157946L;

    @Override
    public String getDatabaseGeneratedReferencedColumnValue()
    {
        return "current_date";
    }

    @Override
    public GenerationTiming getGenerationTiming()
    {
        return GenerationTiming.ALWAYS;
    }

    @Override
    public ValueGenerator<?> getValueGenerator()
    {
        return null;
    }

    @Override
    public boolean referenceColumnInSql()
    {
        return true;
    }

    @Override
    public void initialize(FunctionLastUpdatedDatetime arg0, Class<?> arg1)
    {

    }

}
