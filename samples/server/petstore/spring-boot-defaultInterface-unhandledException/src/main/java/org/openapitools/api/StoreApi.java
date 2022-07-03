/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.util.Map;
import org.openapitools.model.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "store", description = "Access to Petstore orders")
public interface StoreApi {

    /**
     * DELETE /store/order/{order_id} : Delete purchase order by ID
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
     *
     * @param orderId ID of the order that needs to be deleted (required)
     * @return Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     */
    @Operation(
        operationId = "deleteOrder",
        summary = "Delete purchase order by ID",
        tags = { "store" },
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Order not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/store/order/{order_id}"
    )
    ResponseEntity<Void> deleteOrder(
        @Parameter(name = "order_id", description = "ID of the order that needs to be deleted", required = true) @PathVariable("order_id") String orderId
    ) throws Exception;


    /**
     * GET /store/inventory : Returns pet inventories by status
     * Returns a map of status codes to quantities
     *
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getInventory",
        summary = "Returns pet inventories by status",
        tags = { "store" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))
            })
        },
        security = {
            @SecurityRequirement(name = "api_key")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/store/inventory",
        produces = { "application/json" }
    )
    ResponseEntity<Map<String, Integer>> getInventory(
        
    ) throws Exception;


    /**
     * GET /store/order/{order_id} : Find purchase order by ID
     * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generated exceptions
     *
     * @param orderId ID of pet that needs to be fetched (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     */
    @Operation(
        operationId = "getOrderById",
        summary = "Find purchase order by ID",
        tags = { "store" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = Order.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Order not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/store/order/{order_id}",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<Order> getOrderById(
        @Min(1L) @Max(5L) @Parameter(name = "order_id", description = "ID of pet that needs to be fetched", required = true) @PathVariable("order_id") Long orderId
    ) throws Exception;


    /**
     * POST /store/order : Place an order for a pet
     *
     * @param body order placed for purchasing the pet (required)
     * @return successful operation (status code 200)
     *         or Invalid Order (status code 400)
     */
    @Operation(
        operationId = "placeOrder",
        summary = "Place an order for a pet",
        tags = { "store" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = Order.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid Order")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/store/order",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<Order> placeOrder(
        @Parameter(name = "body", description = "order placed for purchasing the pet", required = true) @Valid @RequestBody Order body
    ) throws Exception;

}
