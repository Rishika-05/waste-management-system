ALTER TABLE `waste` ADD COLUMN `collection_requested` bit(1) DEFAULT false;
ALTER TABLE `waste` ADD COLUMN `transported` bit(1) DEFAULT false;
ALTER TABLE `waste` ADD COLUMN `processed` bit(1) DEFAULT false;
