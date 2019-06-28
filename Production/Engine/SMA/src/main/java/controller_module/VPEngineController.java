/*
 * Axel Polin 2019
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 */

package controller_module;


import processing.core.*;
import processing.core.PApplet;
import fr.inria.papart.multitouch.detection.TouchDetectionDepth;
import tech.lity.rea.skatolo.Skatolo;
import tech.lity.rea.skatolo.events.ControlEvent;

import model_module.VPEngineModel;
import view_module.VPEngineView;
import view_module.Const;

public class VPEngineController {	
	
	PApplet parent;
	private TouchDetectionDepth fingerDetection;
	private Skatolo skatolo;
	
	public VPEngineView vpEngineView;
	
	public boolean updateView = true;
	public boolean updateModel = false;
	public boolean updateController = false;
	
	public int level = 0;
	public PImage background;
	
	public VPEngineController(PApplet parent, TouchDetectionDepth fingerDetection){
		this.parent = parent;
		this.fingerDetection = fingerDetection;
		vpEngineView = new VPEngineView(this,fingerDetection,Const.Common.SCREENOBJECT_X, Const.Common.SCREENOBJECT_Y, Const.Common.INTERACTION_WIDTH_MILLIMETER, Const.Common.INTERACTION_HEIGHT_MILLIMETER);
		
	}
			
	public void mainLoop(){
		
        //if (background != null) {vpEngineView.UpdateView();}
		
		if (updateView == true){
			switch (level){
				case 0:
					PImage[] ButtonsLinks = {
						parent.loadImage(VPEngineModel.Levels.TittleScreen.ButtonStartGameImageNOSEL),
						parent.loadImage(VPEngineModel.Levels.TittleScreen.ButtonStartGameImageSEL),
						parent.loadImage(VPEngineModel.Levels.TittleScreen.ButtonStartGameImageSEL)
					};
					background = parent.loadImage(VPEngineModel.Levels.TittleScreen.Background);
					background.resize(VPEngineModel.ProjectionWidth,VPEngineModel.ProjectionHeight);
					
					vpEngineView.background = background;
					vpEngineView.TittleScreen(ButtonsLinks);
			}
			updateView = false;
		}
		if (updateModel == true){
			updateModel = false;
		}
		if (updateController == true){
			updateController = false;
		}
	
	}
	
	public void startGame(){
		System.out.println("We are in startGame");
	}
	
	public void selectChapter(){
		System.out.println("We are in selectChapter");
	}

}