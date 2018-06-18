package com.manywho.services.stripe.charge;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;

@Action.Metadata(name = "Create Charge", summary = "Execute Charge", uri = "charge-create")
public class CreateCharge {
    public static class Input {
        @Action.Input(name = "Charge", contentType = ContentType.Object)
        private Charge charge;

        @Action.Input(name = "Tokens", contentType = ContentType.Object)
        private Token token;

        public Charge getCharge() {
            return charge;
        }

        public Token getToken() {return token; }
    }

    public static class Output {
        @Action.Output(name = "Charge", contentType = ContentType.Object)
        private Charge charge;

        public Output(Charge charge) {
            this.charge = charge;
        }
    }
}
