/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoftviewer;

/**
 *
 * @author roger
 */

    public enum ModuleNamePosition{
        REM_BEGIN(41),
        REM_END(43),
        FOP_BEGIN(0),
        FOP_END(10);
        public int value;
        
        private ModuleNamePosition(int value){
        this.value = value;
        }
    
}

