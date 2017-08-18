package Bean;

import java.math.BigDecimal;

public class WeldingNumber {
private double high;
private double angle;
private int WN;
public void setWN(String high,String angle)
{
	this.angle=Math.toRadians(Double.parseDouble(angle));
	this.high=Double.parseDouble(high);
	this.WN=new BigDecimal(this.high/(Math.cos(this.angle/2)))
            .setScale(0, BigDecimal.ROUND_HALF_UP)
            .intValue();
}
public Integer getWN()
{
	return this.WN;
}
}
