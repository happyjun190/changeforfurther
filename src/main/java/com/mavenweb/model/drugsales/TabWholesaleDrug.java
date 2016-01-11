package com.mavenweb.model.drugsales;

import java.math.BigDecimal;

/**
 * 药品活动model
 * @author shenjun
 * 20160111
 */
public class TabWholesaleDrug {

	private int id;
	private String wholesale_name;
	private int drug_id;
	private int provider_id;
	private int begin_date;
	private int end_date;
	private String unit;
	private BigDecimal unit_price;
	private int min_amount;
	private int order;
	private int is_top;
	private String image_url;
	private int top_order;
	private String detail;
	private int init_amount;
	private int paid_amount;
	private BigDecimal current_price;
	private int ctime;
	private int mtime;
	private int status;
	private int return_time;
	private int return_user;
	private String specification;// 规格和包装
	private int wholesale_type;// 批发种类: 0-返现活动, 1-一口价, 2-限量秒杀, 3-折扣活动

	private int state;// 数据库没有这个字段，用来记录批发采购活动目前状态

	private String bottom_price_url;// 一口价图片url
	private String bottom_price_desc;// 一口价说明
	private int max_amount;// 采购上限，0或者null是不限制上限,仅用于 2-限量特惠
	private String drug_name;

	private int rush_status;// 特惠活动状态,非数据库字段
	private int type_flag;// 是否特惠活动,非数据库字段，0是，1不是
	private int order_id;// 排序序号,非数据库字段

	private Long rush_begin_date;// 抢购活动起始时间戳，仅用于 2-限量特惠'
	private Long rush_end_date;// 抢购活动结束时间戳，仅用于 2-限量特惠

	private int max_amount_per_store;// 单店购买上限，仅用于 2-限量特惠
	private int max_amount_per_user;// 用户购买上限，，仅用于 2-限量特惠
	private int order_amount;// 已下单数量:下单时增加，取消订单时减少

	private Long db_timestamp;// 数据库时间

	private String push_ad_url;// 广告url
	private String push_ad_jump;// 广告跳转url
	private String push_ad_title;// 广告跳转标题
	private String image_title;// 置顶广告跳转标题
	private String image_jump;// 置顶广告跳转url

	private int have_invoice;// 是否含票，0-空白，1-含票
	private String desc_ext;// 活动补充描述,补充在bottom_price_desc前
	
	private int promotion_type;//促销类别，0-无，1-新品，2-特价，...，参考 ts_sys_dict.YSBE_WS_PROMOTION_TYPE

	private int presellId;
	
	private Long area_group_id;//开通地区组ID,关联`db_ysb_dictionary`.`ts_group_area`
	
	private BigDecimal chain_price;//连锁采购价
	
	private String logo;// 列表页药品图片地址
	
	//v2.6.0药品批发活动计划表
	private String drug_name_prefix;// 药品活动前缀
	private int calculate_begin_date;// 已购买数量计算起始时间
	
	// v2.7.0控销
	private int is_restrict;// 是否控销品种，0-否，1-是
	private int restrict_group_id;// 控销药店分组ID
	private int recommend_order;// 推荐到首页后的排序顺序
	
	// v3.0.0 套餐销售
	private int sale_type;//1单品销售 2 打包销售,默认1
	private int step;// 购买增量、步长
	private BigDecimal old_price;// 原价
	private int wsdrugasktype_id;//二级分类id
	private int wsdrugasktype_parentid;//一级分类id
	private int calculate_period;//0- 不限制（活动期）， 1-单笔， 2-每天，3-每周，4-每月
	private int prov_object;//供货对象 1-全部  2-连锁总部 3-非连锁',
	
	private int total_record;//非数据库字段,记录查询总数
	
	private String druginfo_cn_name;   // 从 solr 获取的 drugInfo表对应cn_name，用于自动完成
	private int total_pay_amount;   // 从 solr 获取的 total_pay_amount，计算后的总销量
	
	private int stock_available;// 可用库存
	
	private int tag_listorder; // 药品在某tag里面的listorder，需要根据tagid取出

	public int getStock_available() {
		return stock_available;
	}

	public void setStock_available(int stock_available) {
		this.stock_available = stock_available;
	}
	public int getTotal_record() {
		return total_record;
	}

	public void setTotal_record(int total_record) {
		this.total_record = total_record;
	}

	@Override
	public int hashCode(){  // 重载hashCode为了使用cacheable
		return id;
	}
	
	public int getProv_object() {
		return prov_object;
	}

	public void setProv_object(int prov_object) {
		this.prov_object = prov_object;
	}

	public int getWsdrugasktype_id() {
		return wsdrugasktype_id;
	}

	public void setWsdrugasktype_id(int wsdrugasktype_id) {
		this.wsdrugasktype_id = wsdrugasktype_id;
	}

	public int getWsdrugasktype_parentid() {
		return wsdrugasktype_parentid;
	}

	public void setWsdrugasktype_parentid(int wsdrugasktype_parentid) {
		this.wsdrugasktype_parentid = wsdrugasktype_parentid;
	}

	public int getSale_type() {
		return sale_type;
	}

	public void setSale_type(int sale_type) {
		this.sale_type = sale_type;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public BigDecimal getOld_price() {
		return old_price;
	}

	public void setOld_price(BigDecimal old_price) {
		this.old_price = old_price;
	}

	public int getRecommend_order() {
		return recommend_order;
	}

	public void setRecommend_order(int recommend_order) {
		this.recommend_order = recommend_order;
	}

	public int getIs_restrict() {
		return is_restrict;
	}

	public void setIs_restrict(int is_restrict) {
		this.is_restrict = is_restrict;
	}

	public int getRestrict_group_id() {
		return restrict_group_id;
	}

	public void setRestrict_group_id(int restrict_group_id) {
		this.restrict_group_id = restrict_group_id;
	}

	public String getDrug_name_prefix() {
		return drug_name_prefix;
	}

	public void setDrug_name_prefix(String drug_name_prefix) {
		this.drug_name_prefix = drug_name_prefix;
	}

	public int getCalculate_begin_date() {
		return calculate_begin_date;
	}

	public void setCalculate_begin_date(int calculate_begin_date) {
		this.calculate_begin_date = calculate_begin_date;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getArea_group_id() {
		return area_group_id;
	}

	public void setArea_group_id(Long area_group_id) {
		this.area_group_id = area_group_id;
	}

	public int getPresellId() {
		return presellId;
	}

	public void setPresellId(int presellId) {
		this.presellId = presellId;
	}

	public int getPromotion_type() {
		return promotion_type;
	}

	public void setPromotion_type(int promotion_type) {
		this.promotion_type = promotion_type;
	}

	public String getDesc_ext() {
		return desc_ext;
	}

	public void setDesc_ext(String desc_ext) {
		this.desc_ext = desc_ext;
	}

	public int getHave_invoice() {
		return have_invoice;
	}

	public void setHave_invoice(int have_invoice) {
		this.have_invoice = have_invoice;
	}

	public String getPush_ad_title() {
		return push_ad_title;
	}

	public void setPush_ad_title(String push_ad_title) {
		this.push_ad_title = push_ad_title;
	}

	public String getImage_title() {
		return image_title;
	}

	public void setImage_title(String image_title) {
		this.image_title = image_title;
	}

	public String getImage_jump() {
		return image_jump;
	}

	public void setImage_jump(String image_jump) {
		this.image_jump = image_jump;
	}

	public String getPush_ad_url() {
		return push_ad_url;
	}

	public void setPush_ad_url(String push_ad_url) {
		this.push_ad_url = push_ad_url;
	}

	public String getPush_ad_jump() {
		return push_ad_jump;
	}

	public void setPush_ad_jump(String push_ad_jump) {
		this.push_ad_jump = push_ad_jump;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Long getDb_timestamp() {
		return db_timestamp;
	}

	public void setDb_timestamp(Long db_timestamp) {
		this.db_timestamp = db_timestamp;
	}

	public int getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

	public Long getRush_begin_date() {
		return rush_begin_date;
	}

	public void setRush_begin_date(Long rush_begin_date) {
		this.rush_begin_date = rush_begin_date;
	}

	public Long getRush_end_date() {
		return rush_end_date;
	}

	public void setRush_end_date(Long rush_end_date) {
		this.rush_end_date = rush_end_date;
	}

	public int getMax_amount_per_store() {
		return max_amount_per_store;
	}

	public void setMax_amount_per_store(int max_amount_per_store) {
		this.max_amount_per_store = max_amount_per_store;
	}

	public int getMax_amount_per_user() {
		return max_amount_per_user;
	}

	public void setMax_amount_per_user(int max_amount_per_user) {
		this.max_amount_per_user = max_amount_per_user;
	}

	public int getRush_status() {
		return rush_status;
	}

	public void setRush_status(int rush_status) {
		this.rush_status = rush_status;
	}

	public int getType_flag() {
		return type_flag;
	}

	public void setType_flag(int type_flag) {
		this.type_flag = type_flag;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getDrug_name() {
		return drug_name;
	}

	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	public int getMax_amount() {
		return max_amount;
	}

	public void setMax_amount(int max_amount) {
		this.max_amount = max_amount;
	}

	public String getBottom_price_url() {
		return bottom_price_url;
	}

	public void setBottom_price_url(String bottom_price_url) {
		this.bottom_price_url = bottom_price_url;
	}

	public String getBottom_price_desc() {
		return bottom_price_desc;
	}

	public void setBottom_price_desc(String bottom_price_desc) {
		this.bottom_price_desc = bottom_price_desc;
	}

	public int getDrug_id() {
		return drug_id;
	}

	public int getWholesale_type() {
		return wholesale_type;
	}

	public void setWholesale_type(int wholesale_type) {
		this.wholesale_type = wholesale_type;
	}

	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getInit_amount() {
		return init_amount;
	}

	public void setInit_amount(int init_amount) {
		this.init_amount = init_amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWholesale_name() {
		return wholesale_name;
	}

	public void setWholesale_name(String wholesale_name) {
		this.wholesale_name = wholesale_name;
	}

	public int getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}

	public int getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(int begin_date) {
		this.begin_date = begin_date;
	}

	public int getEnd_date() {
		return end_date;
	}

	public void setEnd_date(int end_date) {
		this.end_date = end_date;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}

	public int getMin_amount() {
		return min_amount;
	}

	public void setMin_amount(int min_amount) {
		this.min_amount = min_amount;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getIs_top() {
		return is_top;
	}

	public void setIs_top(int is_top) {
		this.is_top = is_top;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getTop_order() {
		return top_order;
	}

	public void setTop_order(int top_order) {
		this.top_order = top_order;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(int paid_amount) {
		this.paid_amount = paid_amount;
	}

	public BigDecimal getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(BigDecimal current_price) {
		this.current_price = current_price;
	}

	public int getCtime() {
		return ctime;
	}

	public void setCtime(int ctime) {
		this.ctime = ctime;
	}

	public int getMtime() {
		return mtime;
	}

	public void setMtime(int mtime) {
		this.mtime = mtime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getReturn_time() {
		return return_time;
	}

	public void setReturn_time(int return_time) {
		this.return_time = return_time;
	}

	public int getReturn_user() {
		return return_user;
	}

	public void setReturn_user(int return_user) {
		this.return_user = return_user;
	}

	public BigDecimal getChain_price() {
		return chain_price;
	}

	public void setChain_price(BigDecimal chain_price) {
		this.chain_price = chain_price;
	}

	public int getCalculate_period() {
		return calculate_period;
	}

	public void setCalculate_period(int calculate_period) {
		this.calculate_period = calculate_period;
	}

	public String getDruginfo_cn_name() {
		return druginfo_cn_name;
	}

	public void setDruginfo_cn_name(String druginfo_cn_name) {
		this.druginfo_cn_name = druginfo_cn_name;
	}

	public int getTotal_pay_amount() {
		return total_pay_amount;
	}

	public void setTotal_pay_amount(int total_pay_amount) {
		this.total_pay_amount = total_pay_amount;
	}

	public int getTag_listorder() {
		return tag_listorder;
	}

	public void setTag_listorder(int tag_listorder) {
		this.tag_listorder = tag_listorder;
	}

	
	
	
}
