package edu.zxy.apple.entity;

import org.hibernate.tuple.AnnotationValueGeneration;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGenerator;

public class FunctionCreationDatetimeGeneration implements AnnotationValueGeneration<FunctionCreationDatetime>
{

    /**
     * ���к�
     */
    private static final long serialVersionUID = -7524550862085958575L;

    @Override
    public String getDatabaseGeneratedReferencedColumnValue()
    {
        return "now()";
    }

    @Override
    public GenerationTiming getGenerationTiming()
    {
        return GenerationTiming.INSERT;
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
    public void initialize(FunctionCreationDatetime arg0, Class<?> arg1)
    {

    }

}
