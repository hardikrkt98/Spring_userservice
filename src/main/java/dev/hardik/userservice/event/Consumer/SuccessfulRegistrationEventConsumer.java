package dev.hardik.userservice.event.Consumer;

import dev.hardik.userservice.event.SuccessfulRegistrationEvent;
import dev.hardik.userservice.model.User;
import dev.hardik.userservice.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class SuccessfulRegistrationEventConsumer implements ApplicationListener<SuccessfulRegistrationEvent> {


    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Override
    public void onApplicationEvent(SuccessfulRegistrationEvent successfulRegistrationEvent) {
        User registeredUser = successfulRegistrationEvent.getRegisteredUser();

        VerificationToken token = new VerificationToken(registeredUser);

        verificationTokenRepository.save(token);
        //need to send the link containing verification tokern create model containing verification token

    }
}
