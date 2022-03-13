package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.FrmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class CtrlProducto implements ActionListener{
    
    private Producto mod;
    private ConsultasProducto modC;
    private FrmProducto frm;
    
    public CtrlProducto(Producto mod, ConsultasProducto modC, FrmProducto frm)
    {
        
        this.mod= mod;
        this.modC=modC;
        this.frm =frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtIdtbProducto.setVisible(false);
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==frm.btnGuardar)
        {
           
            mod.setDescripcion(frm.txtDescripcion.getText());
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            mod.setPrecioContado(Integer.parseInt(frm.txtPrecioContado.getText()));
            mod.setPrecioMensualidad(Integer.parseInt(frm.txtPrecioMensualidad.getText()));
            mod.setProducto(frm.txtProducto.getText());
            
            if(modC.registrar(mod)){
                
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "ERROR al Registrar");
                limpiar();
            }
            
            
        }
        
        if(e.getSource()==frm.btnModificar)
        {
            mod.setIdtbProducto(Integer.parseInt(frm.txtIdtbProducto.getText()));
            mod.setDescripcion(frm.txtDescripcion.getText());
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            mod.setPrecioContado(Integer.parseInt(frm.txtPrecioContado.getText()));
            mod.setPrecioMensualidad(Integer.parseInt(frm.txtPrecioMensualidad.getText()));
            mod.setProducto(frm.txtProducto.getText());
            
            if(modC.modificar(mod)){
                
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "ERROR al modificar");
                limpiar();
            }
        }
        
        if(e.getSource()==frm.btnEliminar)
        {
            mod.setIdtbProducto(Integer.parseInt(frm.txtIdtbProducto.getText()));
            
            if(modC.eliminar(mod)){
                
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "ERROR al eliminar");
                limpiar();
            }
        }
        
        if(e.getSource()==frm.btnBuscar)
        {
            mod.setProducto(frm.txtProductoB.getText());
            
            if(modC.buscar(mod)){
                
                frm.txtIdtbProducto.setText(String.valueOf(mod.getIdtbProducto()));
                frm.txtDescripcion.setText(mod.getDescripcion());
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                frm.txtPrecioContado.setText(String.valueOf(mod.getPrecioContado()));
                frm.txtPrecioMensualidad.setText(String.valueOf(mod.getPrecioMensualidad()));
                frm.txtProducto.setText(mod.getProducto());
                frm.txtProductoB.setText(null);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el resultado");
                limpiar();
            }
        }
        
        if(e.getSource()==frm.btnLimpiar)
        {
            limpiar();
        }
        
    }
    
    public void limpiar(){
        
        frm.txtIdtbProducto.setText(null);
        frm.txtProducto.setText(null);
        frm.txtDescripcion.setText(null);
        frm.txtCantidad.setText(null);
        frm.txtPrecioContado.setText(null);
        frm.txtPrecioMensualidad.setText(null);
        frm.txtProductoB.setText(null);
    }
    
    
}
