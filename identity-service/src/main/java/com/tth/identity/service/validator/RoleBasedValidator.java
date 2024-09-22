package com.tth.identity.service.validator;

import com.tth.identity.service.dto.request.user.RegisterRequest;
import com.tth.identity.service.validator.constraint.RoleBasedConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RoleBasedValidator implements ConstraintValidator<RoleBasedConstraint, RegisterRequest> {

    @Override
    public boolean isValid(RegisterRequest request, ConstraintValidatorContext context) {
        if (request.getRole() == null) {
            return true; // Nếu role null, validation khác sẽ xử lý, không cần kiểm tra thêm.
        }

        context.disableDefaultConstraintViolation();

        return switch (request.getRole()) {
            case ROLE_CUSTOMER -> this.validateCustomer(request, context);
            case ROLE_SHIPPER -> this.validateShipper(request, context);
            case ROLE_SUPPLIER -> this.validateSupplier(request, context);
            default -> true;
        };
    }

    private boolean validateCustomer(RegisterRequest request, ConstraintValidatorContext context) {
        boolean isValid = true;

        if (request.getCustomerFirstName() == null || request.getCustomerFirstName().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{customer.firstName.notNull}")
                    .addPropertyNode("customerFirstName").addConstraintViolation();
            isValid = false;
        }

        if (request.getCustomerMiddleName() == null || request.getCustomerMiddleName().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{customer.middleName.notNull}")
                    .addPropertyNode("customerMiddleName").addConstraintViolation();
            isValid = false;
        }

        if (request.getCustomerLastName() == null || request.getCustomerLastName().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{customer.lastName.notNull}")
                    .addPropertyNode("customerLastName").addConstraintViolation();
            isValid = false;
        }

        if (request.getCustomerAddress() == null || request.getCustomerAddress().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{customer.address.notNull}")
                    .addPropertyNode("customerAddress").addConstraintViolation();
            isValid = false;
        }

        if (request.getCustomerPhone() == null || request.getCustomerPhone().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{user.phone.notNull}")
                    .addPropertyNode("customerPhone").addConstraintViolation();
            isValid = false;
        }

        if (!request.getCustomerPhone().matches("^[0-9]{10,15}$")) {
            context.buildConstraintViolationWithTemplate("{user.phone.pattern}")
                    .addPropertyNode("customerPhone").addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }

    private boolean validateShipper(RegisterRequest request, ConstraintValidatorContext context) {
        boolean isValid = true;

        if (request.getShipperName() == null || request.getShipperName().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{shipper.name.notNull}")
                    .addPropertyNode("shipperName").addConstraintViolation();
            isValid = false;
        }

        if (request.getShipperContactInfo() == null || request.getShipperContactInfo().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{shipper.contactInfo.notNull}")
                    .addPropertyNode("shipperContactInfo").addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }

    private boolean validateSupplier(RegisterRequest request, ConstraintValidatorContext context) {
        boolean isValid = true;

        if (request.getSupplierName() == null || request.getSupplierName().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{supplier.name.notNull}")
                    .addPropertyNode("supplierName").addConstraintViolation();
            isValid = false;
        }

        if (request.getSupplierAddress() == null || request.getSupplierAddress().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{supplier.address.notNull}")
                    .addPropertyNode("supplierAddress").addConstraintViolation();
            isValid = false;
        }

        if (request.getSupplierPhone() == null || request.getSupplierPhone().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{user.phone.notNull}")
                    .addPropertyNode("supplierPhone").addConstraintViolation();
            isValid = false;
        }

        if (!request.getSupplierPhone().matches("^[0-9]{10,15}$")) {
            context.buildConstraintViolationWithTemplate("{user.phone.pattern}")
                    .addPropertyNode("supplierPhone").addConstraintViolation();
            isValid = false;
        }

        if (request.getSupplierContactInfo() == null || request.getSupplierContactInfo().isEmpty()) {
            context.buildConstraintViolationWithTemplate("{supplier.contactInfo.notNull}")
                    .addPropertyNode("supplierContactInfo").addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
}
