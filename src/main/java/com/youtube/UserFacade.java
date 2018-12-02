package com.youtube;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import static java.util.Optional.*;

import static java.util.stream.Collectors.toList;

public class UserFacade {

    private UserRepo userRepo;
    @Autowired
    private UserMapper mapper;

    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(mapper::toDto).collect(toList());
    }

}

@Component
class UserMapper {

    public UserDto toDto(BIConversion.User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setFullName(user.getUsername() + " " + user.getLastName().toUpperCase());
        dto.setActive(user.getDeactivationDate() == null);
    }

}

class DiscountService {

    public String getDiscountLine(Customer customer) {
        return customer.getMemberCard()
                .flatMap(card -> getDiscountPercentage(card))
                .map(d -> "Discount%: " + d)
                .orElse("");
    }

    private Optional<Integer> getDiscountPercentage(MemberCard card) {
        if (card.getFidelityPoints() >= 100) {
            return of(5);
        }
        if (card.getFidelityPoints() >= 50) {
            return of(3);
        }
        return empty();
    }
}

class Customer {
    private MemberCard memberCard;

    public Customer(MemberCard memberCard) {
        this.memberCard = memberCard;
    }

    public MemberCard getMemberCard() {
        return memberCard;
    }
}

class MemberCard {
    private int fidelityPoints;

    public int getFidelityPoints() {
        return fidelityPoints;
    }

    public MemberCard(int fidelityPoints) {
        this.fidelityPoints = fidelityPoints;
    }
}