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

import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.flowingcode.vaadin.addons.flipcard.FlipCard.FlipCardVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@DemoSource
@PageTitle("Flip Card Demo")
@Route(value = "flip-card/basic", layout = FlipCardDemoView.class)
public class FlipCardDemo extends Div {

  public FlipCardDemo() {
    Div onHoverFront = new Div();
    onHoverFront.setClassName("front-card");
    Icon onHoverIcon = new Icon(VaadinIcon.POINTER);
    onHoverFront.add(onHoverIcon, new Span("hover"));

    Div onHoverBack = new Div();
    onHoverBack.setClassName("back-card");
    onHoverBack.add(new Span("Card flips on hover."));

    FlipCard onHoverFlipCard = new FlipCard(onHoverFront, onHoverBack);
    onHoverFlipCard.setClassName("flip-card-basic");
    add(onHoverFlipCard);

    Div onClickFront = new Div();
    onClickFront.setClassName("front-card");
    Icon onClickIcon = new Icon(VaadinIcon.TOUCH);
    onClickFront.add(onClickIcon, new Span("click"));

    Div onClickBack = new Div();
    onClickBack.setClassName("back-card");
    onClickBack.add(new Span("Card flips on click."));

    FlipCard onClickFlipCard = new FlipCard(onClickFront, onClickBack, FlipCardVariant.CLICK);
    onClickFlipCard.setClassName("flip-card-basic");
    add(onClickFlipCard);
  }
}
