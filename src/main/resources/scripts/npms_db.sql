/*
Navicat MySQL Data Transfer

Source Server         : connection1
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : npms

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-07-30 00:12:11
*/

drop database if exists npms;
create database npms;
use npms;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for approvallog
-- ----------------------------
DROP TABLE IF EXISTS `approvallog`;
CREATE TABLE `approvallog` (
  `app_id` int NOT NULL AUTO_INCREMENT,
  `app_flow_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_opp_id` int DEFAULT NULL,
  `app_submit_people` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_submit_date` datetime DEFAULT NULL,
  `app_people` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_status` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_opinion` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_result` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`app_id`),
  KEY `approvallog_opportunity_buffer_oppb_id_fk` (`app_opp_id`),
  CONSTRAINT `approvallog_opportunity_buffer_oppb_id_fk` FOREIGN KEY (`app_opp_id`) REFERENCES `opportunity_buffer` (`oppb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of approvallog
-- ----------------------------

-- ----------------------------
-- Table structure for c_agree_degree
-- ----------------------------
DROP TABLE IF EXISTS `c_agree_degree`;
CREATE TABLE `c_agree_degree` (
  `agree_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `agree_degree` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`agree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_agree_degree
-- ----------------------------
INSERT INTO `c_agree_degree` VALUES ('10', '完全支持');
INSERT INTO `c_agree_degree` VALUES ('20', '支持');
INSERT INTO `c_agree_degree` VALUES ('30', '中立');

-- ----------------------------
-- Table structure for c_bu
-- ----------------------------
DROP TABLE IF EXISTS `c_bu`;
CREATE TABLE `c_bu` (
  `cbu_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `cbu_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cbu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_bu
-- ----------------------------
INSERT INTO `c_bu` VALUES ('01', '行业事业一部');
INSERT INTO `c_bu` VALUES ('02', '行业事业二部');
INSERT INTO `c_bu` VALUES ('03', '行业事业三部');
INSERT INTO `c_bu` VALUES ('04', '行业事业四部');
INSERT INTO `c_bu` VALUES ('05', '行业事业五部');
INSERT INTO `c_bu` VALUES ('06', '产品事业一部');
INSERT INTO `c_bu` VALUES ('07', '产品事业二部');
INSERT INTO `c_bu` VALUES ('08', '产品事业三部');
INSERT INTO `c_bu` VALUES ('09', '产品事业四部');
INSERT INTO `c_bu` VALUES ('10', '产品事业五部');
INSERT INTO `c_bu` VALUES ('11', '行业事业一部-咨询一部');
INSERT INTO `c_bu` VALUES ('12', '行业事业一部-咨询二部');
INSERT INTO `c_bu` VALUES ('13', '行业事业三部-咨询部');
INSERT INTO `c_bu` VALUES ('14', '行业事业三部-业务拓展部');
INSERT INTO `c_bu` VALUES ('15', '产品事业一部-产品咨询部');
INSERT INTO `c_bu` VALUES ('16', '产品事业一部-产品开发部');

-- ----------------------------
-- Table structure for c_business_type
-- ----------------------------
DROP TABLE IF EXISTS `c_business_type`;
CREATE TABLE `c_business_type` (
  `bus_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `bus_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`bus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_business_type
-- ----------------------------
INSERT INTO `c_business_type` VALUES ('01', '第三方软件服务');
INSERT INTO `c_business_type` VALUES ('02', '第三方软件产品');
INSERT INTO `c_business_type` VALUES ('03', '自有软件产品');
INSERT INTO `c_business_type` VALUES ('04', '自有软件产品服务');
INSERT INTO `c_business_type` VALUES ('05', '系统集成');
INSERT INTO `c_business_type` VALUES ('06', '非产品开发');
INSERT INTO `c_business_type` VALUES ('07', '产品研发');

-- ----------------------------
-- Table structure for c_compete_pos
-- ----------------------------
DROP TABLE IF EXISTS `c_compete_pos`;
CREATE TABLE `c_compete_pos` (
  `cp_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `cp_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_compete_pos
-- ----------------------------
INSERT INTO `c_compete_pos` VALUES ('10', '唯一选择');
INSERT INTO `c_compete_pos` VALUES ('20', '领跑者');
INSERT INTO `c_compete_pos` VALUES ('30', '旗鼓相当');
INSERT INTO `c_compete_pos` VALUES ('40', '落后');

-- ----------------------------
-- Table structure for c_customer_relation
-- ----------------------------
DROP TABLE IF EXISTS `c_customer_relation`;
CREATE TABLE `c_customer_relation` (
  `cusrel_relation_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `cusrel_relation_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cusrel_relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_customer_relation
-- ----------------------------
INSERT INTO `c_customer_relation` VALUES ('10', '母公司');
INSERT INTO `c_customer_relation` VALUES ('20', '子公司');
INSERT INTO `c_customer_relation` VALUES ('30', '控股公司');

-- ----------------------------
-- Table structure for c_customer_status
-- ----------------------------
DROP TABLE IF EXISTS `c_customer_status`;
CREATE TABLE `c_customer_status` (
  `cus_status_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `cus_status_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cus_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_customer_status
-- ----------------------------
INSERT INTO `c_customer_status` VALUES ('10', '正常');
INSERT INTO `c_customer_status` VALUES ('20', '冻结');

-- ----------------------------
-- Table structure for c_effect
-- ----------------------------
DROP TABLE IF EXISTS `c_effect`;
CREATE TABLE `c_effect` (
  `effect_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `effect_degree` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`effect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_effect
-- ----------------------------
INSERT INTO `c_effect` VALUES ('10', '高');
INSERT INTO `c_effect` VALUES ('20', '中');
INSERT INTO `c_effect` VALUES ('30', '低');

-- ----------------------------
-- Table structure for c_enterprise_property
-- ----------------------------
DROP TABLE IF EXISTS `c_enterprise_property`;
CREATE TABLE `c_enterprise_property` (
  `ep_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `ep_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_enterprise_property
-- ----------------------------
INSERT INTO `c_enterprise_property` VALUES ('10', '外商投资');
INSERT INTO `c_enterprise_property` VALUES ('20', '中外合资');
INSERT INTO `c_enterprise_property` VALUES ('30', '国有企业');
INSERT INTO `c_enterprise_property` VALUES ('40', '民营企业');
INSERT INTO `c_enterprise_property` VALUES ('99', '其他');

-- ----------------------------
-- Table structure for c_opp_origin
-- ----------------------------
DROP TABLE IF EXISTS `c_opp_origin`;
CREATE TABLE `c_opp_origin` (
  `coo_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `coo_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`coo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_opp_origin
-- ----------------------------
INSERT INTO `c_opp_origin` VALUES ('10', '公司');
INSERT INTO `c_opp_origin` VALUES ('20', '个人');
INSERT INTO `c_opp_origin` VALUES ('30', '厂商');

-- ----------------------------
-- Table structure for c_opportunity_status
-- ----------------------------
DROP TABLE IF EXISTS `c_opportunity_status`;
CREATE TABLE `c_opportunity_status` (
  `opp_status_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `opp_status_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`opp_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_opportunity_status
-- ----------------------------
INSERT INTO `c_opportunity_status` VALUES ('10', '草稿');
INSERT INTO `c_opportunity_status` VALUES ('20', '流程中');
INSERT INTO `c_opportunity_status` VALUES ('30', '正常');
INSERT INTO `c_opportunity_status` VALUES ('40', '暂停');
INSERT INTO `c_opportunity_status` VALUES ('50', '关闭');
INSERT INTO `c_opportunity_status` VALUES ('60', '退回');

-- ----------------------------
-- Table structure for c_payer
-- ----------------------------
DROP TABLE IF EXISTS `c_payer`;
CREATE TABLE `c_payer` (
  `pay_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `pay_decision` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_payer
-- ----------------------------
INSERT INTO `c_payer` VALUES ('10', '最终决策人');
INSERT INTO `c_payer` VALUES ('20', '决策人');
INSERT INTO `c_payer` VALUES ('30', '技术负责人');
INSERT INTO `c_payer` VALUES ('40', '使用人');

-- ----------------------------
-- Table structure for c_position
-- ----------------------------
DROP TABLE IF EXISTS `c_position`;
CREATE TABLE `c_position` (
  `pos_id` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `pos_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`pos_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_position
-- ----------------------------
INSERT INTO `c_position` VALUES ('10000030', '事业部总经理');
INSERT INTO `c_position` VALUES ('20000010', '营销副总');
INSERT INTO `c_position` VALUES ('20000020', '营销专员');
INSERT INTO `c_position` VALUES ('30000010', '销售总监');
INSERT INTO `c_position` VALUES ('30000030', '客户经理');
INSERT INTO `c_position` VALUES ('50000000', '高层领导');

-- ----------------------------
-- Table structure for c_product
-- ----------------------------
DROP TABLE IF EXISTS `c_product`;
CREATE TABLE `c_product` (
  `cpro_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `cpro_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cpro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_product
-- ----------------------------
INSERT INTO `c_product` VALUES ('01', 'SAP');
INSERT INTO `c_product` VALUES ('02', 'ORACLE');
INSERT INTO `c_product` VALUES ('03', 'NSRM');
INSERT INTO `c_product` VALUES ('06', 'NPMS');
INSERT INTO `c_product` VALUES ('07', 'NFOL');

-- ----------------------------
-- Table structure for c_product_bu_rel
-- ----------------------------
DROP TABLE IF EXISTS `c_product_bu_rel`;
CREATE TABLE `c_product_bu_rel` (
  `cpbr_id` int NOT NULL AUTO_INCREMENT,
  `cpbr_pro_id` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpbr_bu_id` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cpbr_id`),
  KEY `c_product_bu_rel_c_product_cpro_id_fk` (`cpbr_pro_id`),
  KEY `c_product_bu_rel_c_bu_cbu_id_fk` (`cpbr_bu_id`),
  CONSTRAINT `c_product_bu_rel_c_bu_cbu_id_fk` FOREIGN KEY (`cpbr_bu_id`) REFERENCES `c_bu` (`cbu_id`),
  CONSTRAINT `c_product_bu_rel_c_product_cpro_id_fk` FOREIGN KEY (`cpbr_pro_id`) REFERENCES `c_product` (`cpro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_product_bu_rel
-- ----------------------------
INSERT INTO `c_product_bu_rel` VALUES ('1', '01', '01');
INSERT INTO `c_product_bu_rel` VALUES ('2', '01', '02');
INSERT INTO `c_product_bu_rel` VALUES ('3', '01', '03');
INSERT INTO `c_product_bu_rel` VALUES ('4', '01', '04');
INSERT INTO `c_product_bu_rel` VALUES ('5', '02', '05');
INSERT INTO `c_product_bu_rel` VALUES ('6', '03', '06');
INSERT INTO `c_product_bu_rel` VALUES ('7', '06', '07');
INSERT INTO `c_product_bu_rel` VALUES ('8', '07', '07');

-- ----------------------------
-- Table structure for c_project_sub_opp_type
-- ----------------------------
DROP TABLE IF EXISTS `c_project_sub_opp_type`;
CREATE TABLE `c_project_sub_opp_type` (
  `pso_id` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `pso_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`pso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_project_sub_opp_type
-- ----------------------------
INSERT INTO `c_project_sub_opp_type` VALUES ('01', '第三方软件产品实施');
INSERT INTO `c_project_sub_opp_type` VALUES ('02', '定制开发');
INSERT INTO `c_project_sub_opp_type` VALUES ('05', '第三方服务');
INSERT INTO `c_project_sub_opp_type` VALUES ('06', '第三方软件产品');
INSERT INTO `c_project_sub_opp_type` VALUES ('07', '第三方软件产品维护费');
INSERT INTO `c_project_sub_opp_type` VALUES ('08', '自有软件产品实施');
INSERT INTO `c_project_sub_opp_type` VALUES ('09', '自有软件产品');
INSERT INTO `c_project_sub_opp_type` VALUES ('12', '硬件产品');
INSERT INTO `c_project_sub_opp_type` VALUES ('14', '非产品开发');
INSERT INTO `c_project_sub_opp_type` VALUES ('15', '产品开发');

-- ----------------------------
-- Table structure for c_project_type_product_rel
-- ----------------------------
DROP TABLE IF EXISTS `c_project_type_product_rel`;
CREATE TABLE `c_project_type_product_rel` (
  `cptpr_id` int NOT NULL AUTO_INCREMENT,
  `cptpr_bus_id` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cptpr_pro_id` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cptpr_id`),
  KEY `c_project_type_product_rel_c_product_cpro_id_fk` (`cptpr_pro_id`),
  KEY `c_project_type_product_rel_c_project_sub_opp_type_pso_id_fk` (`cptpr_bus_id`),
  CONSTRAINT `c_project_type_product_rel_c_product_cpro_id_fk` FOREIGN KEY (`cptpr_pro_id`) REFERENCES `c_product` (`cpro_id`),
  CONSTRAINT `c_project_type_product_rel_c_project_sub_opp_type_pso_id_fk` FOREIGN KEY (`cptpr_bus_id`) REFERENCES `c_project_sub_opp_type` (`pso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_project_type_product_rel
-- ----------------------------
INSERT INTO `c_project_type_product_rel` VALUES ('8', '01', '01');
INSERT INTO `c_project_type_product_rel` VALUES ('9', '01', '02');
INSERT INTO `c_project_type_product_rel` VALUES ('10', '06', '01');
INSERT INTO `c_project_type_product_rel` VALUES ('11', '06', '02');
INSERT INTO `c_project_type_product_rel` VALUES ('12', '07', '01');
INSERT INTO `c_project_type_product_rel` VALUES ('13', '07', '02');
INSERT INTO `c_project_type_product_rel` VALUES ('14', '08', '03');
INSERT INTO `c_project_type_product_rel` VALUES ('15', '08', '06');
INSERT INTO `c_project_type_product_rel` VALUES ('16', '08', '07');
INSERT INTO `c_project_type_product_rel` VALUES ('17', '09', '03');
INSERT INTO `c_project_type_product_rel` VALUES ('18', '09', '06');
INSERT INTO `c_project_type_product_rel` VALUES ('19', '09', '07');

-- ----------------------------
-- Table structure for competitor
-- ----------------------------
DROP TABLE IF EXISTS `competitor`;
CREATE TABLE `competitor` (
  `comp_id` int NOT NULL AUTO_INCREMENT,
  `comp_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comp_position` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comp_opp_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`comp_id`),
  KEY `competitor_c_compete_pos_cp_id_fk` (`comp_position`),
  KEY `competitor_opportunity_opp_id_fk` (`comp_opp_id`),
  CONSTRAINT `competitor_c_compete_pos_cp_id_fk` FOREIGN KEY (`comp_position`) REFERENCES `c_compete_pos` (`cp_id`),
  CONSTRAINT `competitor_opportunity_opp_id_fk` FOREIGN KEY (`comp_opp_id`) REFERENCES `opportunity` (`opp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of competitor
-- ----------------------------
INSERT INTO `competitor` VALUES ('1', '小米', '30', '20210004');
INSERT INTO `competitor` VALUES ('2', 'NBA', '20', '20210001');
INSERT INTO `competitor` VALUES ('3', 'NCAA', '30', '20210001');
INSERT INTO `competitor` VALUES ('4', '中软', '30', '20210003');
INSERT INTO `competitor` VALUES ('8', null, null, '20210007');
INSERT INTO `competitor` VALUES ('9', 'test4对手', null, '20210008');

-- ----------------------------
-- Table structure for competitor_buffer
-- ----------------------------
DROP TABLE IF EXISTS `competitor_buffer`;
CREATE TABLE `competitor_buffer` (
  `compb_id` int NOT NULL AUTO_INCREMENT,
  `compb_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `compb_position` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `compb_opp_id` int DEFAULT NULL,
  PRIMARY KEY (`compb_id`),
  KEY `competitor_buffer_c_compete_pos_cp_id_fk` (`compb_position`),
  KEY `competitor_buffer_opportunity_buffer_oppb_id_fk` (`compb_opp_id`),
  CONSTRAINT `competitor_buffer_c_compete_pos_cp_id_fk` FOREIGN KEY (`compb_position`) REFERENCES `c_compete_pos` (`cp_id`),
  CONSTRAINT `competitor_buffer_opportunity_buffer_oppb_id_fk` FOREIGN KEY (`compb_opp_id`) REFERENCES `opportunity_buffer` (`oppb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of competitor_buffer
-- ----------------------------
INSERT INTO `competitor_buffer` VALUES ('1', null, null, '4');
INSERT INTO `competitor_buffer` VALUES ('2', null, null, '5');
INSERT INTO `competitor_buffer` VALUES ('3', null, null, '6');
INSERT INTO `competitor_buffer` VALUES ('6', null, null, '25');
INSERT INTO `competitor_buffer` VALUES ('7', null, null, '26');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `con_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `con_customer_id` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_dept` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_role` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_landline_phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_mobile_phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_fax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_email` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_qq` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `con_wechat` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`con_id`),
  KEY `contact_customer_cus_id_fk` (`con_customer_id`),
  CONSTRAINT `contact_customer_cus_id_fk` FOREIGN KEY (`con_customer_id`) REFERENCES `customer` (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1414102004387594124', '800002', 'George', 'sales', 'manager', '65539171', '17136381916', '123461', '1231@qq.com', '12383617', '32973216');
INSERT INTO `contact` VALUES ('1414102004387594212', '800001', 'Kate', 'sales', 'manager', '65539171', '17136381916', '123461', '1231@qq.com', '12383617', '32973216');
INSERT INTO `contact` VALUES ('1414102004387594242', '800001', 'Leo', 'sales', 'manager', '65539171', '17136381916', '123461', '1231@qq.com', '12383617', '32973216');
INSERT INTO `contact` VALUES ('1414102004387594245', '800001', 'James', 'sales', 'manager', '65539171', '17136381916', '123461', '1231@qq.com', '12383617', '32973216');
INSERT INTO `contact` VALUES ('1414102004387594555', '800002', 'Mike', 'sales', 'manager', '65539171', '17136381916', '123461', '1231@qq.com', '12383617', '32973216');
INSERT INTO `contact` VALUES ('1414167929556090882', '800007', 'David', null, null, null, null, null, null, null, null);
INSERT INTO `contact` VALUES ('1414170713080811521', '800008', 'David', null, null, null, null, null, null, null, null);
INSERT INTO `contact` VALUES ('1414428898534420482', '800009', 'Tim', 'sales', 'manager', '666666', '17136381916', '123461', '666666@qq.com', '12383617', '32973216');
INSERT INTO `contact` VALUES ('1418055183986921473', '800012', 'Rise', 'sales', 'manager', '65539171', '17136381916', '123461', '1231@qq.com', '12383617', '32973216');
INSERT INTO `contact` VALUES ('1418055184007892994', '800012', 'Oxford', 'sales', 'manager', '65539171', '17136381916', '123461', '1231@qq.com', '12383617', '32973216');
INSERT INTO `contact` VALUES ('1418059155149754369', '800009', 'Lucas', 'sales', 'manager', '65539171', '17136381916', '123461', '1231@qq.com', '12383617', '32973216');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cus_id` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `cus_name` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `cus_country` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_city` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_address` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_postcode` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_website` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_taxpayer_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `cus_tax_category` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_account_allocation_section` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_enterprise_property` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_annual_sales_revenue` double DEFAULT NULL,
  `cus_product_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_software_brand` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_effect_of_informationization` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_sales_dept_id` varchar(7) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_customer_manager_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_status` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cus_id`),
  UNIQUE KEY `customer_cus_taxpayer_id_uindex` (`cus_taxpayer_id`),
  KEY `customer_c_customer_status_cus_status_id_fk` (`cus_status`),
  KEY `customer_c_enterprise_property_ep_id_fk` (`cus_enterprise_property`),
  KEY `customer_department_dept_id_fk` (`cus_sales_dept_id`),
  KEY `customer_employee_emp_id_fk` (`cus_customer_manager_id`),
  CONSTRAINT `customer_c_customer_status_cus_status_id_fk` FOREIGN KEY (`cus_status`) REFERENCES `c_customer_status` (`cus_status_id`),
  CONSTRAINT `customer_c_enterprise_property_ep_id_fk` FOREIGN KEY (`cus_enterprise_property`) REFERENCES `c_enterprise_property` (`ep_id`),
  CONSTRAINT `customer_department_dept_id_fk` FOREIGN KEY (`cus_sales_dept_id`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `customer_employee_emp_id_fk` FOREIGN KEY (`cus_customer_manager_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('800001', 'HUAWEI', 'China', 'Beijing', 'Beijing Chaoyang district rose appartment 103 room', '110110', 'www.huawei.com', '1', '1', '10', '30', '300000', 'IT', 'HUAWEI phones', 'good', '8021140', '800123', '10');
INSERT INTO `customer` VALUES ('800002', 'Honnor', 'China', 'Beijing', 'Beijing Chaoyang district rose appartment 203 room', '111110', 'www.honnor.com', '2', '1', '10', '30', '300000', 'IT', 'Honnor phones', 'good', '8021140', '800123', '10');
INSERT INTO `customer` VALUES ('800003', 'Tencent', 'China', 'Guangdong', 'Guangdong good district green house 801room', '134262', 'www.tencent.com', '3', '1', '10', '30', '300000', 'IT', 'CF', 'good', '8021140', '800126', '10');
INSERT INTO `customer` VALUES ('800004', 'Neusoft', 'China', 'Shenyang', 'Shenyang hunnan district zhihui street 300', '119119', 'www.huawei.com', '4', '1', '10', '30', '300000', 'IT', 'HIS', 'fantastic', '8021130', '800127', '10');
INSERT INTO `customer` VALUES ('800005', 'Neuedu', 'China', 'Shenyang', 'Shenyang hunnan district zhihui street 300', '119119', 'www.neusoft.edu.com', '5', '1', '10', '30', '300000', 'IT', 'NEU', 'fantastic', '8021130', '800127', '10');
INSERT INTO `customer` VALUES ('800006', 'CBA', 'China', 'Beijing', 'Beijing street001', '110110', 'www.cba.com', '6', '1', '10', '30', '300000', 'sport', 'CBA', 'good', '8021130', '800127', '10');
INSERT INTO `customer` VALUES ('800007', 'NBA', 'USA', 'LA', '100 Street', '110110', 'www.nba.com', '7', '1', '10', '30', '300000', 'sport', 'NBA', 'good', '8021140', '800126', '10');
INSERT INTO `customer` VALUES ('800008', 'NBL', 'USA', 'LA', '100 Street', '110110', 'www.nbl.com', '9999', '1', '10', '20', '300000', 'sport', 'NBL', 'good', '8021140', '800126', '10');
INSERT INTO `customer` VALUES ('800009', 'NCAA', 'CNC', 'LAC', '800 Street', '898989', 'abc.com', '1111', '1', '10', '20', '100000', 'sport', 'NCAA', 'good', '8021140', '800123', '10');
INSERT INTO `customer` VALUES ('800010', 'OPPO', 'China', 'Beijing', '300 Street', '222222', 'www.oppo.com', '1000', '1', '10', '30', '100000', 'IT', 'phone', 'good', '8031100', '800132', '10');
INSERT INTO `customer` VALUES ('800011', 'DELL', 'USA', 'NY', '300 Street', '222222', 'www.dell.com', '123', '1', '10', '30', '100000', 'IT', 'computer', 'good', '8031100', '800132', '10');
INSERT INTO `customer` VALUES ('800012', 'ACER', 'China', 'NY', '100 Street', '111000', 'www.acer.com', '8849921', '1', '10', '20', '100000', 'IT', 'computer', 'good', '8021140', '800123', '20');

-- ----------------------------
-- Table structure for customer_related
-- ----------------------------
DROP TABLE IF EXISTS `customer_related`;
CREATE TABLE `customer_related` (
  `cusrel_id` int NOT NULL AUTO_INCREMENT,
  `cusrel_cus_id` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cusrel_cus_related_cus_id` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cusrel_relation` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cusrel_id`),
  KEY `customer_related_c_customer_relation_cusrel_relation_id_fk` (`cusrel_relation`),
  KEY `customer_related_customer_cus_id_fk` (`cusrel_cus_id`),
  KEY `customer_related_customer_cus_id_fk_2` (`cusrel_cus_related_cus_id`),
  CONSTRAINT `customer_related_c_customer_relation_cusrel_relation_id_fk` FOREIGN KEY (`cusrel_relation`) REFERENCES `c_customer_relation` (`cusrel_relation_id`),
  CONSTRAINT `customer_related_customer_cus_id_fk` FOREIGN KEY (`cusrel_cus_id`) REFERENCES `customer` (`cus_id`),
  CONSTRAINT `customer_related_customer_cus_id_fk_2` FOREIGN KEY (`cusrel_cus_related_cus_id`) REFERENCES `customer` (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of customer_related
-- ----------------------------
INSERT INTO `customer_related` VALUES ('1', '800001', '800002', '10');
INSERT INTO `customer_related` VALUES ('2', '800001', '800003', '10');
INSERT INTO `customer_related` VALUES ('3', '800001', '800006', '10');
INSERT INTO `customer_related` VALUES ('4', '800004', '800005', '10');
INSERT INTO `customer_related` VALUES ('5', '800004', '800006', '10');
INSERT INTO `customer_related` VALUES ('15', '800007', '800001', '10');
INSERT INTO `customer_related` VALUES ('16', '800008', '800001', '10');
INSERT INTO `customer_related` VALUES ('28', '800012', '800001', '10');
INSERT INTO `customer_related` VALUES ('31', '800009', '800004', '10');
INSERT INTO `customer_related` VALUES ('32', '800009', '800001', '10');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dept_id` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `dept_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('8011000', '总经理室');
INSERT INTO `department` VALUES ('8012000', '总经理办公室');
INSERT INTO `department` VALUES ('8015000', '人事行政中心');
INSERT INTO `department` VALUES ('8015010', '人力资源部');
INSERT INTO `department` VALUES ('8015020', '行政管理部');
INSERT INTO `department` VALUES ('8021110', '销售一部');
INSERT INTO `department` VALUES ('8021120', '销售二部');
INSERT INTO `department` VALUES ('8021130', '销售三部');
INSERT INTO `department` VALUES ('8021140', '销售四部');
INSERT INTO `department` VALUES ('8021150', '销售五部');
INSERT INTO `department` VALUES ('8021210', '市场部');
INSERT INTO `department` VALUES ('8031100', '行业事业一部');
INSERT INTO `department` VALUES ('8031110', '行业事业一部-咨询一部');
INSERT INTO `department` VALUES ('8031120', '行业事业一部-咨询二部');
INSERT INTO `department` VALUES ('8031200', '行业事业二部');
INSERT INTO `department` VALUES ('8031310', '行业事业三部-咨询部');
INSERT INTO `department` VALUES ('8031320', '行业事业三部-业务拓展部');
INSERT INTO `department` VALUES ('8042100', '产品事业一部');
INSERT INTO `department` VALUES ('8042110', '产品事业一部-产品咨询部');
INSERT INTO `department` VALUES ('8042120', '产品事业一部-产品开发部');
INSERT INTO `department` VALUES ('8042210', '产品事业二部-产品咨询部');
INSERT INTO `department` VALUES ('8042220', '产品事业二部-WMS产品部');
INSERT INTO `department` VALUES ('8042300', '产品事业三部');
INSERT INTO `department` VALUES ('8042400', '产品事业四部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `emp_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `emp_password` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emp_dept_id` varchar(7) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emp_position_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `employee_c_position_pos_id_fk` (`emp_position_id`),
  KEY `employee_department_dept_id_fk` (`emp_dept_id`),
  CONSTRAINT `employee_c_position_pos_id_fk` FOREIGN KEY (`emp_position_id`) REFERENCES `c_position` (`pos_id`),
  CONSTRAINT `employee_department_dept_id_fk` FOREIGN KEY (`emp_dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('800123', 'tom', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8021140', '30000030');
INSERT INTO `employee` VALUES ('800124', 'jerry', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8011000', '10000030');
INSERT INTO `employee` VALUES ('800125', 'jack', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8021140', '30000010');
INSERT INTO `employee` VALUES ('800126', 'kate', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8021140', '30000030');
INSERT INTO `employee` VALUES ('800127', 'paul', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8021130', '30000030');
INSERT INTO `employee` VALUES ('800128', 'jim', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8015000', '50000000');
INSERT INTO `employee` VALUES ('800129', 'kim', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8021210', '20000010');
INSERT INTO `employee` VALUES ('800130', 'petter', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8021210', '20000020');
INSERT INTO `employee` VALUES ('800131', 'lucy', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8031100', '30000030');
INSERT INTO `employee` VALUES ('800132', 'david', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8031100', '30000030');
INSERT INTO `employee` VALUES ('800133', 'rose', '$2a$10$/vLKJQQz7pjZayaG7Ht/y.B9SAqbTIHf854giBBme4rW2k9e1yWIa', '8031100', '10000030');

-- ----------------------------
-- Table structure for handoverlog
-- ----------------------------
DROP TABLE IF EXISTS `handoverlog`;
CREATE TABLE `handoverlog` (
  `h_id` int NOT NULL AUTO_INCREMENT,
  `h_out_cus_manager_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `h_in_cus_manager_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `h_cus_id` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `h_opp_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`h_id`),
  KEY `handoverLog_employee_emp_id_fk` (`h_out_cus_manager_id`),
  KEY `handoverLog_employee_emp_id_fk_2` (`h_in_cus_manager_id`),
  KEY `handoverLog_opportunity_opp_id_fk` (`h_opp_id`),
  KEY `handoverlog_customer_cus_id_fk` (`h_cus_id`),
  CONSTRAINT `handoverlog_customer_cus_id_fk` FOREIGN KEY (`h_cus_id`) REFERENCES `customer` (`cus_id`),
  CONSTRAINT `handoverLog_employee_emp_id_fk` FOREIGN KEY (`h_out_cus_manager_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `handoverLog_employee_emp_id_fk_2` FOREIGN KEY (`h_in_cus_manager_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `handoverLog_opportunity_opp_id_fk` FOREIGN KEY (`h_opp_id`) REFERENCES `opportunity` (`opp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of handoverlog
-- ----------------------------
INSERT INTO `handoverlog` VALUES ('6', '800127', '800125', '800006', '20210001');
INSERT INTO `handoverlog` VALUES ('7', '800127', '800125', '800006', '20210002');
INSERT INTO `handoverlog` VALUES ('16', '800125', '800127', '800006', '20210001');
INSERT INTO `handoverlog` VALUES ('17', '800125', '800127', '800006', '20210002');
INSERT INTO `handoverlog` VALUES ('18', '800127', '800125', '800006', '20210001');
INSERT INTO `handoverlog` VALUES ('19', '800127', '800125', '800006', '20210002');
INSERT INTO `handoverlog` VALUES ('20', '800125', '800127', '800006', '20210001');
INSERT INTO `handoverlog` VALUES ('21', '800125', '800127', '800006', '20210002');

-- ----------------------------
-- Table structure for opportunity
-- ----------------------------
DROP TABLE IF EXISTS `opportunity`;
CREATE TABLE `opportunity` (
  `opp_id` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `opp_name` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_sales_dept` varchar(7) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_customer_manager_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_sign_time` datetime DEFAULT NULL,
  `opp_belonging` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_status` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_phase` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_type` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_product` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_background` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_cigarettes` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_cus_id` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opp_origin` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`opp_id`),
  KEY `opportunity_c_opportunity_status_opp_status_id_fk` (`opp_status`),
  KEY `opportunity_c_project_sub_opp_type_pso_id_fk` (`opp_type`),
  KEY `opportunity_department_dept_id_fk` (`opp_sales_dept`),
  KEY `opportunity_employee_emp_id_fk` (`opp_customer_manager_id`),
  KEY `opportunity_customer_cus_id_fk` (`opp_cus_id`),
  KEY `opportunity_c_product_cpro_id_fk` (`opp_product`),
  KEY `opportunity_c_bu_cbu_id_fk` (`opp_belonging`),
  KEY `opportunity_c_opp_origin_coo_id_fk` (`opp_origin`),
  CONSTRAINT `opportunity_c_bu_cbu_id_fk` FOREIGN KEY (`opp_belonging`) REFERENCES `c_bu` (`cbu_id`),
  CONSTRAINT `opportunity_c_opp_origin_coo_id_fk` FOREIGN KEY (`opp_origin`) REFERENCES `c_opp_origin` (`coo_id`),
  CONSTRAINT `opportunity_c_opportunity_status_opp_status_id_fk` FOREIGN KEY (`opp_status`) REFERENCES `c_opportunity_status` (`opp_status_id`),
  CONSTRAINT `opportunity_c_product_cpro_id_fk` FOREIGN KEY (`opp_product`) REFERENCES `c_product` (`cpro_id`),
  CONSTRAINT `opportunity_c_project_sub_opp_type_pso_id_fk` FOREIGN KEY (`opp_type`) REFERENCES `c_project_sub_opp_type` (`pso_id`),
  CONSTRAINT `opportunity_customer_cus_id_fk` FOREIGN KEY (`opp_cus_id`) REFERENCES `customer` (`cus_id`),
  CONSTRAINT `opportunity_department_dept_id_fk` FOREIGN KEY (`opp_sales_dept`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `opportunity_employee_emp_id_fk` FOREIGN KEY (`opp_customer_manager_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of opportunity
-- ----------------------------
INSERT INTO `opportunity` VALUES ('20210001', 'CBA机会1号', '8021130', '800125', '2021-05-12 15:50:45', '01', '30', 'D', '01', '01', '无', '1', '800006', '10');
INSERT INTO `opportunity` VALUES ('20210002', 'CBA机会2号', '8021130', '800125', '2021-05-12 15:50:53', '01', '30', 'A', '01', '02', '无', '1', '800006', '10');
INSERT INTO `opportunity` VALUES ('20210003', '东软机会1号', '8021130', '800127', '2021-06-12 23:50:57', '02', '30', 'D', '01', '01', 'OMG', '0', '800004', '10');
INSERT INTO `opportunity` VALUES ('20210004', '华为机会1号', '8021140', '800123', '2021-05-14 23:51:01', '01', '20', 'E', '01', '01', 'ffffffffff', '0', '800001', '10');
INSERT INTO `opportunity` VALUES ('20210005', 'OPPO机会1号', '8031100', '800132', '2021-05-14 23:51:01', '01', '30', 'D', '01', '01', 'none', '0', '800010', '10');
INSERT INTO `opportunity` VALUES ('20210006', 'DELL机会1号', '8031100', '800132', '2021-05-14 23:51:01', '01', '30', 'C', '01', '01', 'none', '0', '800011', '10');
INSERT INTO `opportunity` VALUES ('20210007', 'test339', '8021140', '800123', '2021-05-14 23:51:01', '03', '30', 'D', '01', '01', 'ffffffffff', '0', '800001', '10');
INSERT INTO `opportunity` VALUES ('20210008', 'test4', '8021140', '800123', '2021-05-14 23:51:01', '03', '30', 'C', '01', '01', 'ffffffffff', '0', '800001', '10');

-- ----------------------------
-- Table structure for opportunity_buffer
-- ----------------------------
DROP TABLE IF EXISTS `opportunity_buffer`;
CREATE TABLE `opportunity_buffer` (
  `oppb_id` int NOT NULL AUTO_INCREMENT,
  `oppb_name` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_sales_dept` varchar(7) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_customer_manager_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_sign_time` datetime DEFAULT NULL,
  `oppb_belonging` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_status` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_phase` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_type` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_product` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_background` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_cigarettes` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_cus_id` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_approve_status` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_opp_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_origin` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oppb_submit_date` date DEFAULT NULL,
  PRIMARY KEY (`oppb_id`),
  KEY `opportunity_buffer_c_business_type_bus_id_fk` (`oppb_type`),
  KEY `opportunity_buffer_c_opportunity_status_opp_status_id_fk` (`oppb_status`),
  KEY `opportunity_buffer_c_product_cpro_id_fk` (`oppb_product`),
  KEY `opportunity_buffer_customer_cus_id_fk` (`oppb_cus_id`),
  KEY `opportunity_buffer_department_dept_id_fk` (`oppb_sales_dept`),
  KEY `opportunity_buffer_employee_emp_id_fk` (`oppb_customer_manager_id`),
  KEY `opportunity_buffer_c_bu_cbu_id_fk` (`oppb_belonging`),
  KEY `opportunity_buffer_c_opp_origin_coo_id_fk` (`oppb_origin`),
  CONSTRAINT `opportunity_buffer_c_bu_cbu_id_fk` FOREIGN KEY (`oppb_belonging`) REFERENCES `c_bu` (`cbu_id`),
  CONSTRAINT `opportunity_buffer_c_business_type_bus_id_fk` FOREIGN KEY (`oppb_type`) REFERENCES `c_business_type` (`bus_id`),
  CONSTRAINT `opportunity_buffer_c_opp_origin_coo_id_fk` FOREIGN KEY (`oppb_origin`) REFERENCES `c_opp_origin` (`coo_id`),
  CONSTRAINT `opportunity_buffer_c_opportunity_status_opp_status_id_fk` FOREIGN KEY (`oppb_status`) REFERENCES `c_opportunity_status` (`opp_status_id`),
  CONSTRAINT `opportunity_buffer_c_product_cpro_id_fk` FOREIGN KEY (`oppb_product`) REFERENCES `c_product` (`cpro_id`),
  CONSTRAINT `opportunity_buffer_customer_cus_id_fk` FOREIGN KEY (`oppb_cus_id`) REFERENCES `customer` (`cus_id`),
  CONSTRAINT `opportunity_buffer_department_dept_id_fk` FOREIGN KEY (`oppb_sales_dept`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `opportunity_buffer_employee_emp_id_fk` FOREIGN KEY (`oppb_customer_manager_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of opportunity_buffer
-- ----------------------------
INSERT INTO `opportunity_buffer` VALUES ('1', '华为机会2号', '8021140', '800123', '2021-05-14 23:51:01', '01', '20', 'C', '01', '01', '无', '0', '800001', '0', null, '10', '2021-05-19');
INSERT INTO `opportunity_buffer` VALUES ('2', '华为机会3号', '8021140', '800123', '2021-05-14 23:51:01', '01', '10', 'D', '01', '01', '无', '0', '800001', '0', null, '10', '2021-05-20');
INSERT INTO `opportunity_buffer` VALUES ('4', 'test1', '8021140', '800123', '2021-05-14 23:51:01', '01', '10', 'A', '01', '01', '无', '0', '800001', '0', null, '10', '2021-05-21');
INSERT INTO `opportunity_buffer` VALUES ('5', 'test2', '8021140', '800123', '2021-05-14 23:51:01', '02', '10', 'A', '01', '01', '无', '0', '800001', '0', null, '10', '2021-05-22');
INSERT INTO `opportunity_buffer` VALUES ('6', 'test3', '8021140', '800123', '2021-05-14 23:51:01', '03', '20', 'D', '01', '01', 'ffffffffff', '0', '800001', '1', null, '10', '2021-07-22');
INSERT INTO `opportunity_buffer` VALUES ('15', '东软机会1号', '8021130', '800127', '2021-05-14 23:51:01', '01', '20', 'E', '01', '01', 'hhhhhh', '0', '800004', '0', '20210003', '10', '2021-05-25');
INSERT INTO `opportunity_buffer` VALUES ('21', '东软机会2号', '8021130', '800127', '2021-05-14 23:51:01', '03', '20', 'A', '01', '01', 'ppppppp', '0', '800004', '0', '20210003', '10', '2021-05-26');
INSERT INTO `opportunity_buffer` VALUES ('25', '华为机会6号', '8021140', '800123', '2021-05-14 23:51:01', '03', '20', 'D', '01', '01', 'ffffffffff', '0', '800001', '0', null, '10', '2021-07-22');
INSERT INTO `opportunity_buffer` VALUES ('26', '华为机会8号', '8021140', '800123', '2021-05-14 23:51:01', '02', '20', 'E', '01', '01', 'ffffffffff', '0', '800001', '0', null, '10', '2021-07-22');
INSERT INTO `opportunity_buffer` VALUES ('27', '华为机会1号', '8021140', '800123', '2021-05-14 23:51:01', '02', '20', 'D', '01', '01', 'p200', '0', '800001', '1', '20210004', '10', '2021-07-22');

-- ----------------------------
-- Table structure for payer
-- ----------------------------
DROP TABLE IF EXISTS `payer`;
CREATE TABLE `payer` (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `p_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_dept` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_position` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_decision` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_effect` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_agree` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_opp_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  KEY `payer_c_agree_degree_agree_id_fk` (`p_agree`),
  KEY `payer_c_effect_effect_id_fk` (`p_effect`),
  KEY `payer_c_payer_pay_id_fk` (`p_decision`),
  KEY `payer_opportunity_opp_id_fk` (`p_opp_id`),
  CONSTRAINT `payer_c_agree_degree_agree_id_fk` FOREIGN KEY (`p_agree`) REFERENCES `c_agree_degree` (`agree_id`),
  CONSTRAINT `payer_c_effect_effect_id_fk` FOREIGN KEY (`p_effect`) REFERENCES `c_effect` (`effect_id`),
  CONSTRAINT `payer_c_payer_pay_id_fk` FOREIGN KEY (`p_decision`) REFERENCES `c_payer` (`pay_id`),
  CONSTRAINT `payer_opportunity_opp_id_fk` FOREIGN KEY (`p_opp_id`) REFERENCES `opportunity` (`opp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of payer
-- ----------------------------
INSERT INTO `payer` VALUES ('1', 'Petter', '仓库', '职员', '139999999', '10', '10', '10', '20210001');
INSERT INTO `payer` VALUES ('2', 'Rogger', '仓库', '职员', '139999999', '10', '10', '10', '20210001');
INSERT INTO `payer` VALUES ('3', 'Richird', 'IT', '职员', '139999999', '10', '10', '10', '20210004');
INSERT INTO `payer` VALUES ('4', 'Tomas', 'IT', '职员', '139999999', '10', '10', '10', '20210004');
INSERT INTO `payer` VALUES ('8', null, null, null, null, null, null, null, '20210007');
INSERT INTO `payer` VALUES ('9', 'test4-payer', null, null, null, null, null, null, '20210008');

-- ----------------------------
-- Table structure for payer_buffer
-- ----------------------------
DROP TABLE IF EXISTS `payer_buffer`;
CREATE TABLE `payer_buffer` (
  `pb_id` int NOT NULL AUTO_INCREMENT,
  `pb_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pb_dept` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pb_position` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pb_phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pb_decision` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pb_effect` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pb_agree` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pb_opp_id` int DEFAULT NULL,
  PRIMARY KEY (`pb_id`),
  KEY `payer_buffer_c_agree_degree_agree_id_fk` (`pb_agree`),
  KEY `payer_buffer_c_effect_effect_id_fk` (`pb_effect`),
  KEY `payer_buffer_opportunity_buffer_oppb_id_fk` (`pb_opp_id`),
  KEY `payer_buffer_c_payer_pay_id_fk` (`pb_decision`),
  CONSTRAINT `payer_buffer_c_agree_degree_agree_id_fk` FOREIGN KEY (`pb_agree`) REFERENCES `c_agree_degree` (`agree_id`),
  CONSTRAINT `payer_buffer_c_effect_effect_id_fk` FOREIGN KEY (`pb_effect`) REFERENCES `c_effect` (`effect_id`),
  CONSTRAINT `payer_buffer_c_payer_pay_id_fk` FOREIGN KEY (`pb_decision`) REFERENCES `c_payer` (`pay_id`),
  CONSTRAINT `payer_buffer_opportunity_buffer_oppb_id_fk` FOREIGN KEY (`pb_opp_id`) REFERENCES `opportunity_buffer` (`oppb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of payer_buffer
-- ----------------------------
INSERT INTO `payer_buffer` VALUES ('1', null, null, null, null, null, null, null, '4');
INSERT INTO `payer_buffer` VALUES ('2', null, null, null, null, null, null, null, '5');
INSERT INTO `payer_buffer` VALUES ('3', null, null, null, null, null, null, null, '6');
INSERT INTO `payer_buffer` VALUES ('6', null, null, null, null, null, null, null, '25');
INSERT INTO `payer_buffer` VALUES ('7', null, null, null, null, null, null, null, '26');

-- ----------------------------
-- Table structure for sub_opportunity
-- ----------------------------
DROP TABLE IF EXISTS `sub_opportunity`;
CREATE TABLE `sub_opportunity` (
  `sub_opp_id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `sub_opp_name` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_opp_type` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_opp_product` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_opp_dept` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_opp_currency` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_opp_money` double DEFAULT NULL,
  `sub_opp_opp_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_opp_status` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sub_opp_id`),
  KEY `sub_opportunity_c_project_sub_opp_type_pso_id_fk` (`sub_opp_type`),
  KEY `sub_opportunity_opportunity_opp_id_fk` (`sub_opp_opp_id`),
  KEY `sub_opportunity_c_bu_cbu_id_fk` (`sub_opp_dept`),
  KEY `sub_opportunity_c_product_cpro_id_fk` (`sub_opp_product`),
  KEY `sub_opportunity_c_opportunity_status_opp_status_id_fk` (`sub_opp_status`),
  CONSTRAINT `sub_opportunity_c_bu_cbu_id_fk` FOREIGN KEY (`sub_opp_dept`) REFERENCES `c_bu` (`cbu_id`),
  CONSTRAINT `sub_opportunity_c_opportunity_status_opp_status_id_fk` FOREIGN KEY (`sub_opp_status`) REFERENCES `c_opportunity_status` (`opp_status_id`),
  CONSTRAINT `sub_opportunity_c_product_cpro_id_fk` FOREIGN KEY (`sub_opp_product`) REFERENCES `c_product` (`cpro_id`),
  CONSTRAINT `sub_opportunity_c_project_sub_opp_type_pso_id_fk` FOREIGN KEY (`sub_opp_type`) REFERENCES `c_project_sub_opp_type` (`pso_id`),
  CONSTRAINT `sub_opportunity_opportunity_opp_id_fk` FOREIGN KEY (`sub_opp_opp_id`) REFERENCES `opportunity` (`opp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sub_opportunity
-- ----------------------------
INSERT INTO `sub_opportunity` VALUES ('2020000101', 'CBA1机会1号-子机会1', '01', '01', '01', 'CNY', '5000', '20210001', null);
INSERT INTO `sub_opportunity` VALUES ('2020000102', 'CBA1机会1号-子机会2', '01', '01', '01', 'CNY', '5000', '20210001', null);
INSERT INTO `sub_opportunity` VALUES ('2020000103', 'CBA1机会1号-子机会3', '01', '02', '02', 'CNY', '5000', '20210001', null);
INSERT INTO `sub_opportunity` VALUES ('2020000401', '华为机会1号-子机会1', '01', '01', '02', 'CNY', '5000', '20210004', null);
INSERT INTO `sub_opportunity` VALUES ('2020000402', '华为机会1号-子机会2', '01', '01', '01', 'CNY', '5000', '20210004', null);
INSERT INTO `sub_opportunity` VALUES ('2021000700', null, null, null, null, null, null, '20210007', '30');
INSERT INTO `sub_opportunity` VALUES ('2021000800', 'test4子机会', null, null, null, null, null, '20210008', '30');

-- ----------------------------
-- Table structure for sub_opportunity_buffer
-- ----------------------------
DROP TABLE IF EXISTS `sub_opportunity_buffer`;
CREATE TABLE `sub_opportunity_buffer` (
  `sub_oppb_id` int NOT NULL AUTO_INCREMENT,
  `sub_oppb_name` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_oppb_type` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_oppb_product` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_oppb_dept` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_oppb_currency` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_oppb_money` double DEFAULT NULL,
  `sub_oppb_status` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_oppb_opp_id` int DEFAULT NULL,
  PRIMARY KEY (`sub_oppb_id`),
  KEY `sub_opportunity_buffer_c_bu_cbu_id_fk` (`sub_oppb_dept`),
  KEY `sub_opportunity_buffer_c_opportunity_status_opp_status_id_fk` (`sub_oppb_status`),
  KEY `sub_opportunity_buffer_c_product_cpro_id_fk` (`sub_oppb_product`),
  KEY `sub_opportunity_buffer_c_project_sub_opp_type_pso_id_fk` (`sub_oppb_type`),
  KEY `sub_opportunity_buffer_opportunity_buffer_oppb_id_fk` (`sub_oppb_opp_id`),
  CONSTRAINT `sub_opportunity_buffer_c_bu_cbu_id_fk` FOREIGN KEY (`sub_oppb_dept`) REFERENCES `c_bu` (`cbu_id`),
  CONSTRAINT `sub_opportunity_buffer_c_opportunity_status_opp_status_id_fk` FOREIGN KEY (`sub_oppb_status`) REFERENCES `c_opportunity_status` (`opp_status_id`),
  CONSTRAINT `sub_opportunity_buffer_c_product_cpro_id_fk` FOREIGN KEY (`sub_oppb_product`) REFERENCES `c_product` (`cpro_id`),
  CONSTRAINT `sub_opportunity_buffer_c_project_sub_opp_type_pso_id_fk` FOREIGN KEY (`sub_oppb_type`) REFERENCES `c_project_sub_opp_type` (`pso_id`),
  CONSTRAINT `sub_opportunity_buffer_opportunity_buffer_oppb_id_fk` FOREIGN KEY (`sub_oppb_opp_id`) REFERENCES `opportunity_buffer` (`oppb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sub_opportunity_buffer
-- ----------------------------
INSERT INTO `sub_opportunity_buffer` VALUES ('1', null, null, null, null, null, null, null, '4');
INSERT INTO `sub_opportunity_buffer` VALUES ('2', null, null, null, null, null, null, null, '5');
INSERT INTO `sub_opportunity_buffer` VALUES ('3', null, null, null, null, null, null, null, '6');
INSERT INTO `sub_opportunity_buffer` VALUES ('6', null, null, null, null, null, null, null, '25');
INSERT INTO `sub_opportunity_buffer` VALUES ('7', null, null, null, null, null, null, null, '26');

-- ----------------------------
-- Table structure for trackinglog
-- ----------------------------
DROP TABLE IF EXISTS `trackinglog`;
CREATE TABLE `trackinglog` (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `t_opp_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_type` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_date` datetime DEFAULT NULL,
  `t_our_party` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_cus_party` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_third_party` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_contact_way` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_place` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_contact_condition` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_contact_effect` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  KEY `trackingLog_c_business_type_bus_id_fk` (`t_type`),
  KEY `trackingLog_opportunity_opp_id_fk` (`t_opp_id`),
  CONSTRAINT `trackingLog_c_business_type_bus_id_fk` FOREIGN KEY (`t_type`) REFERENCES `c_business_type` (`bus_id`),
  CONSTRAINT `trackingLog_opportunity_opp_id_fk` FOREIGN KEY (`t_opp_id`) REFERENCES `opportunity` (`opp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of trackinglog
-- ----------------------------
INSERT INTO `trackinglog` VALUES ('1', '20210001', '01', '2021-05-16 10:02:02', 'jim', 'kim', 'tim', '手机', '', 'good', 'good');
INSERT INTO `trackinglog` VALUES ('2', '20210003', '01', '2021-05-18 10:02:09', 'Andy', 'Alex', 'Ajax', '面对面', '东软睿道', 'good', 'good');
INSERT INTO `trackinglog` VALUES ('4', '20210003', '01', '2021-05-18 10:02:09', 'Billy', 'Emma', 'Howard', '面对面', '东北大学', 'good', 'good');
INSERT INTO `trackinglog` VALUES ('5', '20210003', '01', '2021-05-18 10:02:09', 'Bob', 'Eureka', 'Hoo', '面对面', '东北大学', 'good', 'good');

-- ----------------------------
-- Table structure for worklog
-- ----------------------------
DROP TABLE IF EXISTS `worklog`;
CREATE TABLE `worklog` (
  `w_id` int NOT NULL AUTO_INCREMENT,
  `w_time` datetime DEFAULT NULL,
  `w_content` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `w_dept_id` varchar(7) COLLATE utf8_unicode_ci DEFAULT NULL,
  `w_cus_mgr_id` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`w_id`),
  KEY `workLog_department_dept_id_fk` (`w_dept_id`),
  KEY `workLog_employee_emp_id_fk` (`w_cus_mgr_id`),
  CONSTRAINT `workLog_department_dept_id_fk` FOREIGN KEY (`w_dept_id`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `workLog_employee_emp_id_fk` FOREIGN KEY (`w_cus_mgr_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of worklog
-- ----------------------------
