package com.weather.stats;

// Task 5


public class YearAvg implements Comparable<YearAvg> {
    private double temp;
    private int year;
    private double rain;

    public double getTemp() {
        return temp;
    }

    public void setTemp(final double temp) {
        this.temp = temp;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(final double rain) {
        this.rain = rain;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public YearAvg(double temp, int year, double rain) {
        this.temp = temp;
        this.year = year;
        this.rain = rain;
    }

    @Override
    public String toString() {
        return "YearAvg [rain=" + String.format("%3.2f", rain) + ", temp=" + String.format("%3.2f", temp) + ", year="
                + year + "]";
    }
    // Task1
    public String toCSV() {
        return this.getTemp() + "," + this.getYear()+ "," + this.getRain();
    }

    
    

   @Override
    public int compareTo(YearAvg o) {
        Double d1 = Double.valueOf(this.rain);
        if(d1.compareTo(Double.valueOf(o.rain))==0){
            return this.year - o.year;
        }
        return (d1).compareTo(Double.valueOf(o.rain));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(rain);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.temp);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        YearAvg other = (YearAvg) obj;
        if (Double.doubleToLongBits(rain) != Double.doubleToLongBits(other.rain))
            return false;
        if (Double.doubleToLongBits(temp) != Double.doubleToLongBits(other.temp))
            return false;
        if (year != other.year)
            return false;
        return true;
    }

}