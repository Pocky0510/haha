package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.CANdleFaults;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.TwinkleAnimation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.candleID;
import frc.robot.LimelightHelpers;

public class candle extends SubsystemBase {

    private final CANdle candle;

    private RainbowAnimation rainbowAnimation;
    private TwinkleAnimation twinkleAnimation;



    public candle() {
        candle = new CANdle(candleID.CandleID);
        configureCandle();

        rainbowAnimation = new RainbowAnimation(0.5, 0.5, 8);
        twinkleAnimation = new TwinkleAnimation(171, 223, 245, 0, 0.5, 8, TwinkleAnimation.TwinklePercent.Percent64);
    }


    private void configureCandle() {
        CANdleConfiguration config = new CANdleConfiguration();

        config.stripType = CANdle.LEDStripType.RGB;
        config.brightnessScalar = 0.8; 
        config.v5Enabled = true;
        candle.configAllSettings(config);
    }

 
    public void setStaticColor() {
        candle.setLEDs(171, 223, 245); 
        candle.configBrightnessScalar(0.5);
    }

   
    public void startRainbowAnimation() {
        candle.animate(rainbowAnimation);
    }


    public void startStrobeAnimation
    () {
        // StrobeAnimation strobe = new StrobeAnimation(171,223,245, 0, 0.7);
        StrobeAnimation strobe = new StrobeAnimation(171, 223, 245);
        strobe.setSpeed(0);
        strobe.setNumLed(1);
        candle.animate(strobe);
    }

 
    public void startTwinkleAnimation() {
        candle.animate(twinkleAnimation);
    }

 
    public void stopAnimation() {
        candle.clearAnimation(0); 
    }


    public boolean hasFaults() {
        CANdleFaults faults = new CANdleFaults();
        candle.getFaults(faults);
        return faults.hasAnyFault();
    }
    public void periodic(){
double ID = LimelightHelpers.getFiducialID("");

if(ID == 7){
    setStaticColor();
}
else {
    startRainbowAnimation();

}
  
// else if(ID == -1){
//     startRainbowAnimation();
// }
// else if(ID != -1){
//     stopAnimation();
// }
// stopAnimation();


}

    }
