Feature: Login to Upskill feature
  	Go to login page in my Upskill portal


  Scenario Outline: verify the Upskill login page
    Given User navigation for the Login page
    And Enter Username "<Username>" and Password "<Password>"
    Then User should be able to login
    When Dashboard page Open 
    Then User should be able to navigate to Coupons page

    Examples: 
      | Username | Password  |
      | admin    | Admin@123 |


  Scenario Outline: Add Coupons
    Given Fill values with CouponDetails as CouponName "<CouponName>" and Code "<Code>" and Discount "<Discount>" and TotalAmount "<TotalAmount>" and UsesPerCoupon "<UsesPerCoupon>" and UsesPerCustomer "<UsesPerCustomer>" 
    And Select Values from Drop Down for Type and Products and Category and Status 
    And Select Radio buttons for Customer Login and Free Shipping
    And Select Date Start and Date End from Calander
    When Click on Save button
    Then Coupons should display on Coupon list
    
    Examples: 
    |CouponName|Code|Discount|TotalAmount|UsesPerCoupon|UsesPerCustomer|
    |NYFY2022|456|5.0|500.0|2|1|    

    

Scenario: Edit Coupons

    When Click on Edit action on Coupons page and update values
    Then Coupon should update 
    
Scenario: Delete Coupons

    When Click on Delete action for selected coupon
    Then Coupon should be Deleted    
    