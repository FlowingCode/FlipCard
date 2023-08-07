/*-
 * #%L
 * Flip Card Add-on
 * %%
 * Copyright (C) 2023 Flowing Code
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.flowingcode.vaadin.addons.flipcard;

import java.time.LocalDateTime;
import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.flowingcode.vaadin.addons.flipcard.FlipCard.FlipCardVariant;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@DemoSource
@PageTitle("Flip Card as Info Card Demo")
@Route(value = "flip-card/info-card", layout = FlipCardDemoView.class)
public class FlipCardAsInfoCardDemo extends Div {

  public FlipCardAsInfoCardDemo() {
    Div onHoverFront = new Div();
    onHoverFront.setClassName("front-card");
    onHoverFront.add(new Image("images/helsinki.jpg", ""));

    Div onHoverBack = new Div();
    onHoverBack.setClassName("back-card");
    onHoverBack.add(new H4("Picture Information"), createDetailsForm());

    FlipCard onHoverFlipCard = new FlipCard(onHoverFront, onHoverBack);
    onHoverFlipCard.setClassName("flip-card-info-card");
    add(onHoverFlipCard);

    Div onClickFront = new Div();
    onClickFront.setClassName("front-card");
    onClickFront.add(new Image("images/helsinki.jpg", ""));

    Div onClickBack = new Div();
    onClickBack.setClassName("back-card");
    onClickBack.add(new H4("Picture Information"), createDetailsForm());

    FlipCard onClickFlipCard = new FlipCard(onClickFront, onClickBack, FlipCardVariant.CLICK);
    onClickFlipCard.setClassName("flip-card-info-card");
    add(onClickFlipCard);
  }

  private FormLayout createDetailsForm() {
    FormLayout formLayout = new FormLayout();
    formLayout.getStyle().set("--vaadin-form-item-label-width", "2em");

    TextField name = new TextField();
    name.setValue("helsinki.jpg");
    name.setReadOnly(true);
    name.setWidthFull();
    formLayout.addFormItem(name, new Icon("lumo", "photo"));

    DateTimePicker date = new DateTimePicker();
    date.setValue(LocalDateTime.of(2018, 6, 4, 9, 14));
    date.setReadOnly(true);
    date.setWidthFull();
    formLayout.addFormItem(date, new Icon("lumo", "calendar"));

    TextArea description = new TextArea();
    description.setValue("Harbour of Katajanokka, Helsinki, Finland");
    description.setReadOnly(true);
    description.setWidthFull();
    formLayout.addFormItem(description, new Icon("lumo", "menu"));

    Paragraph deviceInfo = new Paragraph();
    deviceInfo.setText(
        "Device information \n NIKON CORPORATION NIKON D3400 \n ƒ/9 | 1/320s | 24mm | ISO100 | EXP 0 | No flash");
    deviceInfo.getStyle().set("white-space", "pre-line");
    formLayout.addFormItem(deviceInfo, new Icon(VaadinIcon.CAMERA));

    return formLayout;
  }
}
