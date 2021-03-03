package com.softserve.itacademy.stage2.ex3;

public class Worker extends Person {

    private String workPosition;
    private int experienceYears;

    public Worker(final String name, final String workPosition, final int experienceYears)
    {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition()
    {
        return workPosition;
    }

    public int getExperienceYears()
    {
        return experienceYears;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Worker))
        {
            return false;
        }
        if(!super.equals(o))
        {
            return false;
        }
        Worker worker = (Worker) o;
        return getName().equals(worker.getName()) && workPosition.equals(worker.getWorkPosition()) && experienceYears == worker.getExperienceYears();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((workPosition == null) ? 0 : workPosition.hashCode());
        result = prime * result + experienceYears;
        return result;
    }

    @Override
    public String toString()
    {
        return "Worker{" + "name='" + getName() + '\'' + ", workPosition='" + workPosition + '\'' + ", experienceYears=" + experienceYears + '}';
    }
}
