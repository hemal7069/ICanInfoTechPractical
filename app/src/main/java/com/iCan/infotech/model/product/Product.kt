package com.iCan.infotech.model.product

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("AssignedProduct")
    var assignedProduct: Any,

    @SerializedName("Attribute")
    var attribute: List<Any>,

    @SerializedName("cCategoryName")
    var cCategoryName: Any,

    @SerializedName("cCsvFile")
    var cCsvFile: String,

    @SerializedName("cDescription")
    var cDescription: String,

    @SerializedName("cImage")
    var cImage: String,

    @SerializedName("cMetaDescription")
    var cMetaDescription: String,

    @SerializedName("cMetaTitle")
    var cMetaTitle: String,

    @SerializedName("cName")
    var cName: String,

    @SerializedName("cProductCode")
    var cProductCode: String,

    @SerializedName("cProductUniqueCode")
    var cProductUniqueCode: String,

    @SerializedName("cRemark1")
    var cRemark1: String,

    @SerializedName("cRemark2")
    var cRemark2: String,

    @SerializedName("cRemark3")
    var cRemark3: String,

    @SerializedName("cSKU")
    var cSKU: String,

    @SerializedName("cShortDescription")
    var cShortDescription: String,

    @SerializedName("cTaxName")
    var cTaxName: Any,

    @SerializedName("cUrlKey")
    var cUrlKey: String,

    @SerializedName("cVendorName")
    var cVendorName: Any,

    @SerializedName("cWarrantyType")
    var cWarrantyType: String,

    @SerializedName("Currency")
    var currency: String,

    @SerializedName("dtCreatedDate")
    var dtCreatedDate: String,

    @SerializedName("dtNewProductFrom")
    var dtNewProductFrom: String,

    @SerializedName("dtNewProductTo")
    var dtNewProductTo: String,

    @SerializedName("dtSpecialPriceFrom")
    var dtSpecialPriceFrom: String,

    @SerializedName("dtSpecialPriceTo")
    var dtSpecialPriceTo: String,

    @SerializedName("fFeelItStock")
    var fFeelItStock: Double,

    @SerializedName("fMRP")
    var fMRP: Double,

    @SerializedName("fPrice")
    var fPrice: Double,

    @SerializedName("fSamplePrice")
    var fSamplePrice: Double,

    @SerializedName("fSpecialPrice")
    var fSpecialPrice: Double,

    @SerializedName("fStock")
    var fStock: Double,

    @SerializedName("Images")
    var images: List<Image>,

    @SerializedName("IsActive")
    var isActive: Boolean,

    @SerializedName("IsBundleProduct")
    var isBundleProduct: Int,

    @SerializedName("IsCartExists")
    var isCartExists: Boolean,

    @SerializedName("IsDisable")
    var isDisable: Boolean,

    @SerializedName("IsFeatured")
    var isFeatured: Boolean,

    @SerializedName("IsFeelItCartExists")
    var isFeelItCartExists: Boolean,

    @SerializedName("IsTrackInventory")
    var isTrackInventory: Boolean,

    @SerializedName("IsVirualProduct")
    var isVirualProduct: Boolean,

    @SerializedName("IswishList")
    var iswishList: Int,

    @SerializedName("MinimumOrderQuantity")
    var minimumOrderQuantity: Any,

    @SerializedName("nAttributeSetId")
    var nAttributeSetId: Int,

    @SerializedName("nBaseCurrencyId")
    var nBaseCurrencyId: Int,

    @SerializedName("nCategoryId")
    var nCategoryId: Int,

    @SerializedName("nLanguageId")
    var nLanguageId: Int,

    @SerializedName("nMinimumStockAlert")
    var nMinimumStockAlert: Int,

    @SerializedName("nOptionTemplatesId")
    var nOptionTemplatesId: Int,

    @SerializedName("nOtherLangProductId")
    var nOtherLangProductId: Int,

    @SerializedName("nParentProductId")
    var nParentProductId: Int,

    @SerializedName("nParentProductIdLanguage")
    var nParentProductIdLanguage: Int,

    @SerializedName("nProductId")
    var nProductId: Int,

    @SerializedName("nSpecialPrice")
    var nSpecialPrice: Int,

    @SerializedName("nTaxId")
    var nTaxId: Int,

    @SerializedName("nUnitType")
    var nUnitType: Int,

    @SerializedName("nUserId")
    var nUserId: Int,

    @SerializedName("nWarrentyDuration")
    var nWarrentyDuration: Int,

    @SerializedName("nWarrentyId")
    var nWarrentyId: Int,

    @SerializedName("nWeight")
    var nWeight: Int,

    @SerializedName("ProductVeriant")
    var productVeriant: Any,

    @SerializedName("SuggestedProject")
    var suggestedProject: Any
)