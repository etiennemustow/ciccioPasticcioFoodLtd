## Ciccio Pasticcio food ltd

Ciccio Pasticcio limited is a food producer specialized in selling amazing delicatessen all over the world. The company is the exclusive distributor for the amazing Uncle Bob's organic dried pears among other products.

The sales process involve customers calling in the sales department where one employee is able to insert the orders into the system so the operations team can proceed with the delivery. Every order must have all necessary information, including the employee who inserted it. 

The products are divided into categories and each product can be associated with only one category.

* Employees
  * Create new
  * Update existing
* Product
  * Create new
  * Update existing
  * List by name
    * Can be partial name
  * List by category name
    * Can be partial name
* Category
  * Create new
  * Update existing
  * List by name
    * Can be partial name
* Orders
  * Create a new order 
    * Check the product is in stock 
    * Check product is not discontinued
    * Check customer exists
      * Create new customer if it does not exist
    * Order can be shipped to address different from customer address
    * Order can be shipped to name different from customer name
  * Update an existing order 
    * Check the product is in stock
    * Check product is not discontinued
  * Mark order as shipped
  * Display order total

We keep the following information on employees:
* Reports to (Employee)
* Last name
* First name
* Title
* Title of courtesy
* Birthdate
* Hire date
* Address
* City
* Region
* Postal code
* Country
* Home phone
* Extension
* Photo
* Notes

We keep the following information on customers:
* Company name
* Contact name
* Title
* Address
* Region
* Postcode
* Country
* Phone
* Fax

We keep the following information on products:
* Category
* Name
* Quantity per unit
* Unit price
* Units in stock
* units in order
* reorder level
* discontinued

We keep the following information on categories:
* Name
* Description
* Picture

We keep the following information on orders:
* Employee
* Customer
* Date
* Required date
* Shipped date
* Freight
* Ship name
* Ship address
* Ship city
* Ship region
* Ship postcode
* Ship country

Orders contain details we call order details:
* Order
* Product
* Unit price
* Quantity
* Discount
