package com.luck.pictureselector;

import java.util.List;

/**
 * Created by toplu1015 on 2018/2/10.
 */

public class Estate {

    private List<EstateBean> Estate;

    public List<EstateBean> getEstate() {
        return Estate;
    }

    public void setEstate(List<EstateBean> Estate) {
        this.Estate = Estate;
    }

    public static class EstateBean {
        /**
         * EstateID : 10
         * Province : 江苏
         * CityName : 昆山市
         * DistrictName : 昆山周边
         * AreaID : null
         * EstateName : 首创青旅岛尚
         * Spell :
         * EstateName2 : null
         * Spell2 : null
         * Address : 昆山锦溪锦商公路与同周路交叉口
         * Status : 售完
         * DateSaleOver : null
         * CompanyDev : 首创青旅置业（置业）有限公司
         * CompanyBuilder : null
         * CompanyAD : null
         * CompanyMgr : 北京盛世物业服务中心
         * DateOpen : 2015-06-29T16:00:00Z
         * DateCanLive : 2015-06-29T16:00:00Z
         * DateApproval : null
         * Square : 550037.0
         * LandNo : null
         * UseYears : 70
         * PropertyUsage : 别墅
         * ContractNo : null
         * CompanyMoneyRegulation : null
         * MoneyAccountName : null
         * MoneyAccount : null
         * MgrPrice : 3.5
         * DeptID : null
         * Remark : null
         * ContractNoPrefix : null
         * ContractAlertDate : 5
         * DateBeginSale : 2014-05-31T16:00:00Z
         * SMSCount : 0
         * IsSubscribeNoNeed : 0
         * FlagTrashed : 0
         * FlagDeleted : 0
         * ModDate : 2017-10-16T09:51:52Z
         * ExDate : 2008-12-31T16:00:00Z
         * EstateIntegerro : null
         * AreaIntegerro : null
         * PeripheralTraffic : null
         * PeripheralFacilities : null
         * EstatePhone : null
         * QuickSalePayTime : null
         * QuickSaleContractTime : null
         * CustShareDate : null
         * EmpToEstateDays : null
         * EstateToOpenDays : null
         * EmpAndEstateToOpenDays : null
         * Features : null
         * BuildingType : null
         * Decoration : 毛坯
         * BizArea : null
         * ParkingNum : 0
         * LandSquare : null
         * DensityRate : 0.68
         * GreenRate : 67.64
         * CompanyDesign : null
         * SaleLicense : null
         * SaleAddress : 同周公路1288号岛尚售楼处
         * XPoInteger : null
         * YPoInteger : null
         * QuitDate : null
         * FlagPromote : null
         * APrice : null
         * FlagTotalShare : 1
         * IntegerroPoInteger : null
         * UnitPriceMin : null
         * UnitPriceMax : null
         * TotalPriceMin : null
         * TotalPriceMax : null
         * AreaMin : null
         * AreaMax : null
         * RoomTypes : null
         * RegDate : 2017-10-16T09:51:52Z
         * CommissionPoInteger : 0.0
         * ShowToSc : 0
         * BegIntegerradeDate : null
         * EndTradeDate : null
         * Commissionpolicy : null
         * Risktip : null
         * FlagSpecial : 0
         * EndSpecialDate : null
         * ShowHot : null
         * SendEmail : 0
         * OnSaleProduct : null
         * CurrentAgentCompany : null
         * CurrentSaleMode : null
         * BYAgentMode : null
         * isNew : 0
         * TurnoverPercentReward : null
         * CashReward : null
         * PrizeReward : null
         * ExchangePrice : null
         * isReward : 0
         * SpecialPermissionType : 0
         * isZY : 0
         * isOrder : 0
         * AreaCovered : null
         * AreaBuilt : null
         * PropertyCategory : null
         * PropertyCompany : null
         * Downpayment : null
         * TCPurchase : null
         * ElectricitySituation : null
         * GroupBuying : 13万抵30万
         * SalesCommission : null
         * VideoUrl : null
         * greenFileMemo : null
         * parkingFileMemo : null
         * developmentFileMemo : null
         * plateFileMemo : null
         * contractFileMemo : null
         * RoomCount : 0
         * SalesRules : null
         * SalesPitch : null
         * Commission : null
         * CommissionRules : 暂无
         * RewardRules : 暂无
         * CommissionFlg : null
         * InquirySource : 1
         */

        private String EstateID;
        private String Province;
        private String CityName;
        private String DistrictName;
        private String AreaID;
        private String EstateName;
        private String Spell;
        private String EstateName2;
        private String Spell2;
        private String Address;
        private String Status;
        private String DateSaleOver;
        private String CompanyDev;
        private String CompanyBuilder;
        private String CompanyAD;
        private String CompanyMgr;
        private String DateOpen;
        private String DateCanLive;
        private String DateApproval;
        private Double Square;
        private String LandNo;
        private Integer UseYears;
        private String PropertyUsage;
        private String ContractNo;
        private String CompanyMoneyRegulation;
        private String MoneyAccountName;
        private String MoneyAccount;
        private Double MgrPrice;
        private String DeptID;
        private String Remark;
        private String ContractNoPrefix;
        private Integer ContractAlertDate;
        private String DateBeginSale;
        private Integer SMSCount;
        private Integer IsSubscribeNoNeed;
        private Integer FlagTrashed;
        private Integer FlagDeleted;
        private String ModDate;
        private String ExDate;
        private String EstateIntegerro;
        private String AreaIntegerro;
        private String PeripheralTraffic;
        private String PeripheralFacilities;
        private String EstatePhone;
        private String QuickSalePayTime;
        private String QuickSaleContractTime;
        private String CustShareDate;
        private String EmpToEstateDays;
        private String EstateToOpenDays;
        private String EmpAndEstateToOpenDays;
        private String Features;
        private String BuildingType;
        private String Decoration;
        private String BizArea;
        private Integer ParkingNum;
        private String LandSquare;
        private Double DensityRate;
        private Double GreenRate;
        private String CompanyDesign;
        private String SaleLicense;
        private String SaleAddress;
        private String XPoInteger;
        private String YPoInteger;
        private String QuitDate;
        private String FlagPromote;
        private String APrice;
        private Integer FlagTotalShare;
        private String IntegerroPoInteger;
        private String UnitPriceMin;
        private String UnitPriceMax;
        private String TotalPriceMin;
        private String TotalPriceMax;
        private String AreaMin;
        private String AreaMax;
        private String RoomTypes;
        private String RegDate;
        private Double CommissionPoInteger;
        private Integer ShowToSc;
        private String BegIntegerradeDate;
        private String EndTradeDate;
        private String Commissionpolicy;
        private String Risktip;
        private Integer FlagSpecial;
        private String EndSpecialDate;
        private String ShowHot;
        private Integer SendEmail;
        private String OnSaleProduct;
        private String CurrentAgentCompany;
        private String CurrentSaleMode;
        private String BYAgentMode;
        private Integer isNew;
        private String TurnoverPercentReward;
        private String CashReward;
        private String PrizeReward;
        private String ExchangePrice;
        private Integer isReward;
        private String SpecialPermissionType;
        private String isZY;
        private String isOrder;
        private String AreaCovered;
        private String AreaBuilt;
        private String PropertyCategory;
        private String PropertyCompany;
        private String Downpayment;
        private String TCPurchase;
        private String ElectricitySituation;
        private String GroupBuying;
        private String SalesCommission;
        private String VideoUrl;
        private String greenFileMemo;
        private String parkingFileMemo;
        private String developmentFileMemo;
        private String plateFileMemo;
        private String contractFileMemo;
        private Integer RoomCount;
        private String SalesRules;
        private String SalesPitch;
        private String Commission;
        private String CommissionRules;
        private String RewardRules;
        private String CommissionFlg;
        private String InquirySource;

        public String getEstateID() {
            return EstateID;
        }

        public void setEstateID(String EstateID) {
            this.EstateID = EstateID;
        }

        public String getProvince() {
            return Province;
        }

        public void setProvince(String Province) {
            this.Province = Province;
        }

        public String getCityName() {
            return CityName;
        }

        public void setCityName(String CityName) {
            this.CityName = CityName;
        }

        public String getDistrictName() {
            return DistrictName;
        }

        public void setDistrictName(String DistrictName) {
            this.DistrictName = DistrictName;
        }

        public String getAreaID() {
            return AreaID;
        }

        public void setAreaID(String AreaID) {
            this.AreaID = AreaID;
        }

        public String getEstateName() {
            return EstateName;
        }

        public void setEstateName(String EstateName) {
            this.EstateName = EstateName;
        }

        public String getSpell() {
            return Spell;
        }

        public void setSpell(String Spell) {
            this.Spell = Spell;
        }

        public String getEstateName2() {
            return EstateName2;
        }

        public void setEstateName2(String EstateName2) {
            this.EstateName2 = EstateName2;
        }

        public String getSpell2() {
            return Spell2;
        }

        public void setSpell2(String Spell2) {
            this.Spell2 = Spell2;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getDateSaleOver() {
            return DateSaleOver;
        }

        public void setDateSaleOver(String DateSaleOver) {
            this.DateSaleOver = DateSaleOver;
        }

        public String getCompanyDev() {
            return CompanyDev;
        }

        public void setCompanyDev(String CompanyDev) {
            this.CompanyDev = CompanyDev;
        }

        public String getCompanyBuilder() {
            return CompanyBuilder;
        }

        public void setCompanyBuilder(String CompanyBuilder) {
            this.CompanyBuilder = CompanyBuilder;
        }

        public String getCompanyAD() {
            return CompanyAD;
        }

        public void setCompanyAD(String CompanyAD) {
            this.CompanyAD = CompanyAD;
        }

        public String getCompanyMgr() {
            return CompanyMgr;
        }

        public void setCompanyMgr(String CompanyMgr) {
            this.CompanyMgr = CompanyMgr;
        }

        public String getDateOpen() {
            return DateOpen;
        }

        public void setDateOpen(String DateOpen) {
            this.DateOpen = DateOpen;
        }

        public String getDateCanLive() {
            return DateCanLive;
        }

        public void setDateCanLive(String DateCanLive) {
            this.DateCanLive = DateCanLive;
        }

        public String getDateApproval() {
            return DateApproval;
        }

        public void setDateApproval(String DateApproval) {
            this.DateApproval = DateApproval;
        }

        public Double getSquare() {
            return Square;
        }

        public void setSquare(Double Square) {
            this.Square = Square;
        }

        public String getLandNo() {
            return LandNo;
        }

        public void setLandNo(String LandNo) {
            this.LandNo = LandNo;
        }

        public Integer getUseYears() {
            return UseYears;
        }

        public void setUseYears(Integer UseYears) {
            this.UseYears = UseYears;
        }

        public String getPropertyUsage() {
            return PropertyUsage;
        }

        public void setPropertyUsage(String PropertyUsage) {
            this.PropertyUsage = PropertyUsage;
        }

        public String getContractNo() {
            return ContractNo;
        }

        public void setContractNo(String ContractNo) {
            this.ContractNo = ContractNo;
        }

        public String getCompanyMoneyRegulation() {
            return CompanyMoneyRegulation;
        }

        public void setCompanyMoneyRegulation(String CompanyMoneyRegulation) {
            this.CompanyMoneyRegulation = CompanyMoneyRegulation;
        }

        public String getMoneyAccountName() {
            return MoneyAccountName;
        }

        public void setMoneyAccountName(String MoneyAccountName) {
            this.MoneyAccountName = MoneyAccountName;
        }

        public String getMoneyAccount() {
            return MoneyAccount;
        }

        public void setMoneyAccount(String MoneyAccount) {
            this.MoneyAccount = MoneyAccount;
        }

        public Double getMgrPrice() {
            return MgrPrice;
        }

        public void setMgrPrice(Double MgrPrice) {
            this.MgrPrice = MgrPrice;
        }

        public String getDeptID() {
            return DeptID;
        }

        public void setDeptID(String DeptID) {
            this.DeptID = DeptID;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getContractNoPrefix() {
            return ContractNoPrefix;
        }

        public void setContractNoPrefix(String ContractNoPrefix) {
            this.ContractNoPrefix = ContractNoPrefix;
        }

        public Integer getContractAlertDate() {
            return ContractAlertDate;
        }

        public void setContractAlertDate(Integer ContractAlertDate) {
            this.ContractAlertDate = ContractAlertDate;
        }

        public String getDateBeginSale() {
            return DateBeginSale;
        }

        public void setDateBeginSale(String DateBeginSale) {
            this.DateBeginSale = DateBeginSale;
        }

        public Integer getSMSCount() {
            return SMSCount;
        }

        public void setSMSCount(Integer SMSCount) {
            this.SMSCount = SMSCount;
        }

        public Integer getIsSubscribeNoNeed() {
            return IsSubscribeNoNeed;
        }

        public void setIsSubscribeNoNeed(Integer IsSubscribeNoNeed) {
            this.IsSubscribeNoNeed = IsSubscribeNoNeed;
        }

        public Integer getFlagTrashed() {
            return FlagTrashed;
        }

        public void setFlagTrashed(Integer FlagTrashed) {
            this.FlagTrashed = FlagTrashed;
        }

        public Integer getFlagDeleted() {
            return FlagDeleted;
        }

        public void setFlagDeleted(Integer FlagDeleted) {
            this.FlagDeleted = FlagDeleted;
        }

        public String getModDate() {
            return ModDate;
        }

        public void setModDate(String ModDate) {
            this.ModDate = ModDate;
        }

        public String getExDate() {
            return ExDate;
        }

        public void setExDate(String ExDate) {
            this.ExDate = ExDate;
        }

        public String getEstateIntegerro() {
            return EstateIntegerro;
        }

        public void setEstateIntegerro(String EstateIntegerro) {
            this.EstateIntegerro = EstateIntegerro;
        }

        public String getAreaIntegerro() {
            return AreaIntegerro;
        }

        public void setAreaIntegerro(String AreaIntegerro) {
            this.AreaIntegerro = AreaIntegerro;
        }

        public String getPeripheralTraffic() {
            return PeripheralTraffic;
        }

        public void setPeripheralTraffic(String PeripheralTraffic) {
            this.PeripheralTraffic = PeripheralTraffic;
        }

        public String getPeripheralFacilities() {
            return PeripheralFacilities;
        }

        public void setPeripheralFacilities(String PeripheralFacilities) {
            this.PeripheralFacilities = PeripheralFacilities;
        }

        public String getEstatePhone() {
            return EstatePhone;
        }

        public void setEstatePhone(String EstatePhone) {
            this.EstatePhone = EstatePhone;
        }

        public String getQuickSalePayTime() {
            return QuickSalePayTime;
        }

        public void setQuickSalePayTime(String QuickSalePayTime) {
            this.QuickSalePayTime = QuickSalePayTime;
        }

        public String getQuickSaleContractTime() {
            return QuickSaleContractTime;
        }

        public void setQuickSaleContractTime(String QuickSaleContractTime) {
            this.QuickSaleContractTime = QuickSaleContractTime;
        }

        public String getCustShareDate() {
            return CustShareDate;
        }

        public void setCustShareDate(String CustShareDate) {
            this.CustShareDate = CustShareDate;
        }

        public String getEmpToEstateDays() {
            return EmpToEstateDays;
        }

        public void setEmpToEstateDays(String EmpToEstateDays) {
            this.EmpToEstateDays = EmpToEstateDays;
        }

        public String getEstateToOpenDays() {
            return EstateToOpenDays;
        }

        public void setEstateToOpenDays(String EstateToOpenDays) {
            this.EstateToOpenDays = EstateToOpenDays;
        }

        public String getEmpAndEstateToOpenDays() {
            return EmpAndEstateToOpenDays;
        }

        public void setEmpAndEstateToOpenDays(String EmpAndEstateToOpenDays) {
            this.EmpAndEstateToOpenDays = EmpAndEstateToOpenDays;
        }

        public String getFeatures() {
            return Features;
        }

        public void setFeatures(String Features) {
            this.Features = Features;
        }

        public String getBuildingType() {
            return BuildingType;
        }

        public void setBuildingType(String BuildingType) {
            this.BuildingType = BuildingType;
        }

        public String getDecoration() {
            return Decoration;
        }

        public void setDecoration(String Decoration) {
            this.Decoration = Decoration;
        }

        public String getBizArea() {
            return BizArea;
        }

        public void setBizArea(String BizArea) {
            this.BizArea = BizArea;
        }

        public Integer getParkingNum() {
            return ParkingNum;
        }

        public void setParkingNum(Integer ParkingNum) {
            this.ParkingNum = ParkingNum;
        }

        public String getLandSquare() {
            return LandSquare;
        }

        public void setLandSquare(String LandSquare) {
            this.LandSquare = LandSquare;
        }

        public Double getDensityRate() {
            return DensityRate;
        }

        public void setDensityRate(Double DensityRate) {
            this.DensityRate = DensityRate;
        }

        public Double getGreenRate() {
            return GreenRate;
        }

        public void setGreenRate(Double GreenRate) {
            this.GreenRate = GreenRate;
        }

        public String getCompanyDesign() {
            return CompanyDesign;
        }

        public void setCompanyDesign(String CompanyDesign) {
            this.CompanyDesign = CompanyDesign;
        }

        public String getSaleLicense() {
            return SaleLicense;
        }

        public void setSaleLicense(String SaleLicense) {
            this.SaleLicense = SaleLicense;
        }

        public String getSaleAddress() {
            return SaleAddress;
        }

        public void setSaleAddress(String SaleAddress) {
            this.SaleAddress = SaleAddress;
        }

        public String getXPoInteger() {
            return XPoInteger;
        }

        public void setXPoInteger(String XPoInteger) {
            this.XPoInteger = XPoInteger;
        }

        public String getYPoInteger() {
            return YPoInteger;
        }

        public void setYPoInteger(String YPoInteger) {
            this.YPoInteger = YPoInteger;
        }

        public String getQuitDate() {
            return QuitDate;
        }

        public void setQuitDate(String QuitDate) {
            this.QuitDate = QuitDate;
        }

        public String getFlagPromote() {
            return FlagPromote;
        }

        public void setFlagPromote(String FlagPromote) {
            this.FlagPromote = FlagPromote;
        }

        public String getAPrice() {
            return APrice;
        }

        public void setAPrice(String APrice) {
            this.APrice = APrice;
        }

        public Integer getFlagTotalShare() {
            return FlagTotalShare;
        }

        public void setFlagTotalShare(Integer FlagTotalShare) {
            this.FlagTotalShare = FlagTotalShare;
        }

        public String getIntegerroPoInteger() {
            return IntegerroPoInteger;
        }

        public void setIntegerroPoInteger(String IntegerroPoInteger) {
            this.IntegerroPoInteger = IntegerroPoInteger;
        }

        public String getUnitPriceMin() {
            return UnitPriceMin;
        }

        public void setUnitPriceMin(String UnitPriceMin) {
            this.UnitPriceMin = UnitPriceMin;
        }

        public String getUnitPriceMax() {
            return UnitPriceMax;
        }

        public void setUnitPriceMax(String UnitPriceMax) {
            this.UnitPriceMax = UnitPriceMax;
        }

        public String getTotalPriceMin() {
            return TotalPriceMin;
        }

        public void setTotalPriceMin(String TotalPriceMin) {
            this.TotalPriceMin = TotalPriceMin;
        }

        public String getTotalPriceMax() {
            return TotalPriceMax;
        }

        public void setTotalPriceMax(String TotalPriceMax) {
            this.TotalPriceMax = TotalPriceMax;
        }

        public String getAreaMin() {
            return AreaMin;
        }

        public void setAreaMin(String AreaMin) {
            this.AreaMin = AreaMin;
        }

        public String getAreaMax() {
            return AreaMax;
        }

        public void setAreaMax(String AreaMax) {
            this.AreaMax = AreaMax;
        }

        public String getRoomTypes() {
            return RoomTypes;
        }

        public void setRoomTypes(String RoomTypes) {
            this.RoomTypes = RoomTypes;
        }

        public String getRegDate() {
            return RegDate;
        }

        public void setRegDate(String RegDate) {
            this.RegDate = RegDate;
        }

        public Double getCommissionPoInteger() {
            return CommissionPoInteger;
        }

        public void setCommissionPoInteger(Double CommissionPoInteger) {
            this.CommissionPoInteger = CommissionPoInteger;
        }

        public Integer getShowToSc() {
            return ShowToSc;
        }

        public void setShowToSc(Integer ShowToSc) {
            this.ShowToSc = ShowToSc;
        }

        public String getBegIntegerradeDate() {
            return BegIntegerradeDate;
        }

        public void setBegIntegerradeDate(String BegIntegerradeDate) {
            this.BegIntegerradeDate = BegIntegerradeDate;
        }

        public String getEndTradeDate() {
            return EndTradeDate;
        }

        public void setEndTradeDate(String EndTradeDate) {
            this.EndTradeDate = EndTradeDate;
        }

        public String getCommissionpolicy() {
            return Commissionpolicy;
        }

        public void setCommissionpolicy(String Commissionpolicy) {
            this.Commissionpolicy = Commissionpolicy;
        }

        public String getRisktip() {
            return Risktip;
        }

        public void setRisktip(String Risktip) {
            this.Risktip = Risktip;
        }

        public Integer getFlagSpecial() {
            return FlagSpecial;
        }

        public void setFlagSpecial(Integer FlagSpecial) {
            this.FlagSpecial = FlagSpecial;
        }

        public String getEndSpecialDate() {
            return EndSpecialDate;
        }

        public void setEndSpecialDate(String EndSpecialDate) {
            this.EndSpecialDate = EndSpecialDate;
        }

        public String getShowHot() {
            return ShowHot;
        }

        public void setShowHot(String ShowHot) {
            this.ShowHot = ShowHot;
        }

        public Integer getSendEmail() {
            return SendEmail;
        }

        public void setSendEmail(Integer SendEmail) {
            this.SendEmail = SendEmail;
        }

        public String getOnSaleProduct() {
            return OnSaleProduct;
        }

        public void setOnSaleProduct(String OnSaleProduct) {
            this.OnSaleProduct = OnSaleProduct;
        }

        public String getCurrentAgentCompany() {
            return CurrentAgentCompany;
        }

        public void setCurrentAgentCompany(String CurrentAgentCompany) {
            this.CurrentAgentCompany = CurrentAgentCompany;
        }

        public String getCurrentSaleMode() {
            return CurrentSaleMode;
        }

        public void setCurrentSaleMode(String CurrentSaleMode) {
            this.CurrentSaleMode = CurrentSaleMode;
        }

        public String getBYAgentMode() {
            return BYAgentMode;
        }

        public void setBYAgentMode(String BYAgentMode) {
            this.BYAgentMode = BYAgentMode;
        }

        public Integer getIsNew() {
            return isNew;
        }

        public void setIsNew(Integer isNew) {
            this.isNew = isNew;
        }

        public String getTurnoverPercentReward() {
            return TurnoverPercentReward;
        }

        public void setTurnoverPercentReward(String TurnoverPercentReward) {
            this.TurnoverPercentReward = TurnoverPercentReward;
        }

        public String getCashReward() {
            return CashReward;
        }

        public void setCashReward(String CashReward) {
            this.CashReward = CashReward;
        }

        public String getPrizeReward() {
            return PrizeReward;
        }

        public void setPrizeReward(String PrizeReward) {
            this.PrizeReward = PrizeReward;
        }

        public String getExchangePrice() {
            return ExchangePrice;
        }

        public void setExchangePrice(String ExchangePrice) {
            this.ExchangePrice = ExchangePrice;
        }

        public Integer getIsReward() {
            return isReward;
        }

        public void setIsReward(Integer isReward) {
            this.isReward = isReward;
        }

        public String getSpecialPermissionType() {
            return SpecialPermissionType;
        }

        public void setSpecialPermissionType(String SpecialPermissionType) {
            this.SpecialPermissionType = SpecialPermissionType;
        }

        public String getIsZY() {
            return isZY;
        }

        public void setIsZY(String isZY) {
            this.isZY = isZY;
        }

        public String getIsOrder() {
            return isOrder;
        }

        public void setIsOrder(String isOrder) {
            this.isOrder = isOrder;
        }

        public String getAreaCovered() {
            return AreaCovered;
        }

        public void setAreaCovered(String AreaCovered) {
            this.AreaCovered = AreaCovered;
        }

        public String getAreaBuilt() {
            return AreaBuilt;
        }

        public void setAreaBuilt(String AreaBuilt) {
            this.AreaBuilt = AreaBuilt;
        }

        public String getPropertyCategory() {
            return PropertyCategory;
        }

        public void setPropertyCategory(String PropertyCategory) {
            this.PropertyCategory = PropertyCategory;
        }

        public String getPropertyCompany() {
            return PropertyCompany;
        }

        public void setPropertyCompany(String PropertyCompany) {
            this.PropertyCompany = PropertyCompany;
        }

        public String getDownpayment() {
            return Downpayment;
        }

        public void setDownpayment(String Downpayment) {
            this.Downpayment = Downpayment;
        }

        public String getTCPurchase() {
            return TCPurchase;
        }

        public void setTCPurchase(String TCPurchase) {
            this.TCPurchase = TCPurchase;
        }

        public String getElectricitySituation() {
            return ElectricitySituation;
        }

        public void setElectricitySituation(String ElectricitySituation) {
            this.ElectricitySituation = ElectricitySituation;
        }

        public String getGroupBuying() {
            return GroupBuying;
        }

        public void setGroupBuying(String GroupBuying) {
            this.GroupBuying = GroupBuying;
        }

        public String getSalesCommission() {
            return SalesCommission;
        }

        public void setSalesCommission(String SalesCommission) {
            this.SalesCommission = SalesCommission;
        }

        public String getVideoUrl() {
            return VideoUrl;
        }

        public void setVideoUrl(String VideoUrl) {
            this.VideoUrl = VideoUrl;
        }

        public String getGreenFileMemo() {
            return greenFileMemo;
        }

        public void setGreenFileMemo(String greenFileMemo) {
            this.greenFileMemo = greenFileMemo;
        }

        public String getParkingFileMemo() {
            return parkingFileMemo;
        }

        public void setParkingFileMemo(String parkingFileMemo) {
            this.parkingFileMemo = parkingFileMemo;
        }

        public String getDevelopmentFileMemo() {
            return developmentFileMemo;
        }

        public void setDevelopmentFileMemo(String developmentFileMemo) {
            this.developmentFileMemo = developmentFileMemo;
        }

        public String getPlateFileMemo() {
            return plateFileMemo;
        }

        public void setPlateFileMemo(String plateFileMemo) {
            this.plateFileMemo = plateFileMemo;
        }

        public String getContractFileMemo() {
            return contractFileMemo;
        }

        public void setContractFileMemo(String contractFileMemo) {
            this.contractFileMemo = contractFileMemo;
        }

        public Integer getRoomCount() {
            return RoomCount;
        }

        public void setRoomCount(Integer RoomCount) {
            this.RoomCount = RoomCount;
        }

        public String getSalesRules() {
            return SalesRules;
        }

        public void setSalesRules(String SalesRules) {
            this.SalesRules = SalesRules;
        }

        public String getSalesPitch() {
            return SalesPitch;
        }

        public void setSalesPitch(String SalesPitch) {
            this.SalesPitch = SalesPitch;
        }

        public String getCommission() {
            return Commission;
        }

        public void setCommission(String Commission) {
            this.Commission = Commission;
        }

        public String getCommissionRules() {
            return CommissionRules;
        }

        public void setCommissionRules(String CommissionRules) {
            this.CommissionRules = CommissionRules;
        }

        public String getRewardRules() {
            return RewardRules;
        }

        public void setRewardRules(String RewardRules) {
            this.RewardRules = RewardRules;
        }

        public String getCommissionFlg() {
            return CommissionFlg;
        }

        public void setCommissionFlg(String CommissionFlg) {
            this.CommissionFlg = CommissionFlg;
        }

        public String getInquirySource() {
            return InquirySource;
        }

        public void setInquirySource(String InquirySource) {
            this.InquirySource = InquirySource;
        }
    }
}
