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

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;

/**
 * Representation of a Flip Card component.
 * 
 * This component is a wrapper for Flip Card Web Component
 * (https://www.npmjs.com/package/flip-card-wc)
 * 
 * @author Paola De Bartolo / Flowing Code
 * 
 */
@SuppressWarnings("serial")
@NpmPackage(value = "flip-card-wc", version = "1.3.0")
@JsModule("flip-card-wc/dist/flip-card-wc.js")
@Tag("flip-card")
public class FlipCard extends Div {

  public enum FlipCardVariant {
    HOVER, CLICK;
  }

  public FlipCard(Component frontComponent, Component backComponent) {
    this.setFrontComponent(frontComponent);
    this.setBackComponent(backComponent);
  }

  public FlipCard(Component frontComponent, Component backComponent, FlipCardVariant variant) {
    this(frontComponent, backComponent);
    this.setVariant(variant);
  }

  /**
   * Sets the mechanism of how the card flips.
   * 
   * @param variant the variant type that specifies the flip behavior of the card
   */
  public void setVariant(FlipCardVariant variant) {
    this.getElement().setProperty("variant", variant.name().toLowerCase());
  }

  /**
   * Returns the variant value that represents the current flip behavior of the card.
   * 
   * @return the current variant value
   */
  public FlipCardVariant getVariant() {
    return FlipCardVariant.valueOf(
        this.getElement().getProperty("variant", FlipCardVariant.HOVER.name()).toUpperCase());
  }

  /**
   * Sets the component that will be display on the front side of the card.
   * 
   * @param component the front side component
   */
  public void setFrontComponent(Component component) {
    Element frontElement = component.getElement();
    frontElement.setAttribute("slot", "front");
    this.getElement().appendChild(frontElement);
  }

  /**
   * Sets the component that will be display on the back side of the card.
   * 
   * @param component the back side component
   */
  public void setBackComponent(Component component) {
    Element backElement = component.getElement();
    backElement.setAttribute("slot", "back");
    this.getElement().appendChild(backElement);
  }

}
