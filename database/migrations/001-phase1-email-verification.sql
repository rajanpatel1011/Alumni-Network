CREATE TABLE IF NOT EXISTS `emailverify` (
  `very_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `token` varchar(16) NOT NULL,
  `code` varchar(16) NOT NULL,
  PRIMARY KEY (`very_id`),
  KEY `idx_emailverify_token_code` (`token`, `code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `tempuserdata`
  ADD COLUMN `very_codeId` int(10) unsigned DEFAULT NULL,
  ADD COLUMN `verify_flag` int(1) unsigned NOT NULL DEFAULT '0',
  ADD KEY `idx_tempuserdata_very_codeId` (`very_codeId`);
