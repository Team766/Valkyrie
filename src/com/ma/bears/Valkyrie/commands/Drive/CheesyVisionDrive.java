/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Drive;

import com.ma.bears.Valkyrie.RobotValues;
/**
 *
 * @author Blevenson
 */
import com.ma.bears.Valkyrie.commands.CommandBase;

public class CheesyVisionDrive extends CommandBase {
    public CheesyVisionDrive() {
        
    }
    
    protected void initialize() {}
    protected void execute() {
        Drive.setLeftSpeed(OI.CheesyVisionLeft);
        Drive.setRightSpeed(OI.CheesyVisionRight);
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {}
    protected void interrupted() {}
}
