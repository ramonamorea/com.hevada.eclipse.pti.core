package com.hevada.eclipse.pti.ui.wizards.fields;

import org.eclipse.php.internal.ui.wizards.fields.StringDialogField;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ComboStringDialogField extends StringDialogField {
  protected String fSelection = "";
  
  protected String[] fSelectionItems = new String[0];
  
  protected Combo fComboControl;
  
  public Control[] doFillIntoGrid(Composite parent, int nColumns) {
    assertEnoughColumns(nColumns);
    Label label = getLabelControl(parent);
    label.setLayoutData(gridDataForLabel(1));
    Combo combo = getComboControl(parent);
    Text text = getTextControl(parent);
    text.setLayoutData(gridDataForText(nColumns - 2));
    refresh();
    return new Control[] { (Control)label, (Control)combo, (Control)text };
  }
  
  public int getNumberOfControls() {
    return 3;
  }
  
  public Text getTextControl(Composite parent) {
    if (this.fTextControl == null) {
      assertCompositeNotNull(parent);
      this.fTextControl = new Text(parent, 2052);
      this.fTextControl.setText(this.fText);
      this.fTextControl.setFont(parent.getFont());
      this.fTextControl.addModifyListener(this.fModifyListener);
      this.fTextControl.setEnabled(isEnabled());
      if (this.fContentAssistProcessor != null)
        createPHPContentAssistant(this.fContentAssistProcessor); 
    } 
    return this.fTextControl;
  }
  
  public Combo getComboControl(Composite parent) {
    if (this.fComboControl == null) {
      assertCompositeNotNull(parent);
      this.fModifyListener = new ModifyListener() {
          public void modifyText(ModifyEvent e) {
            ComboStringDialogField.this.doModifyText(e);
          }
        };
      this.fComboControl = new Combo(parent, 2048);
      this.fComboControl.setText(this.fSelection);
      this.fComboControl.setFont(parent.getFont());
      this.fComboControl.addModifyListener(this.fModifyListener);
      this.fComboControl.setEnabled(isEnabled());
    } 
    return this.fComboControl;
  }
  
  protected void updateEnableState() {
    super.updateEnableState();
    if (isOkToUse((Control)this.fComboControl))
      this.fComboControl.setEnabled(isEnabled()); 
  }
  
  protected void doModifyText(ModifyEvent e) {
    if (isOkToUse((Control)this.fTextControl)) {
      this.fText = this.fTextControl.getText();
      this.fSelection = this.fComboControl.getText();
    } 
    dialogFieldChanged();
  }
  
  public String getSelection() {
    return this.fSelection;
  }
  
  public void setSelection(String selection) {
    this.fSelection = selection;
    if (isOkToUse((Control)this.fComboControl)) {
      this.fComboControl.setText((selection != null) ? selection : "");
    } else {
      dialogFieldChanged();
    } 
  }
  
  public void setSelectionItems(String[] items) {
    this.fSelectionItems = items;
    if (isOkToUse((Control)this.fComboControl)) {
      this.fComboControl.setItems(items);
    } else {
      dialogFieldChanged();
    } 
  }
  
  public void setTextWithoutUpdate(String text) {
    this.fText = text;
    if (isOkToUse((Control)this.fTextControl)) {
      this.fTextControl.removeModifyListener(this.fModifyListener);
      this.fTextControl.setText(text);
      this.fTextControl.addModifyListener(this.fModifyListener);
    } 
  }
  
  public void setText(String text) {
    this.fText = text;
    if (isOkToUse((Control)this.fTextControl)) {
      this.fTextControl.setText(text);
    } else {
      dialogFieldChanged();
    } 
  }
  
  public void setSelectionWithoutUpdate(String selection) {
    this.fSelection = selection;
    if (isOkToUse((Control)this.fComboControl)) {
      this.fComboControl.removeModifyListener(this.fModifyListener);
      this.fComboControl.setText(selection);
      this.fComboControl.addModifyListener(this.fModifyListener);
    } 
  }
  
  public void setSelectionItemsWithoutUpdate(String[] items) {
    this.fSelectionItems = items;
    if (isOkToUse((Control)this.fComboControl)) {
      this.fComboControl.removeModifyListener(this.fModifyListener);
      this.fComboControl.setItems(items);
      this.fComboControl.addModifyListener(this.fModifyListener);
    } 
  }
  
  public void refresh() {
    super.refresh();
    if (isOkToUse((Control)this.fComboControl)) {
      setSelectionItemsWithoutUpdate(this.fSelectionItems);
      setSelectionWithoutUpdate(this.fSelection);
    } 
  }
}
