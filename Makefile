WIKI_DIR     = wiki
MANUAL_DIR   = manual
WIKI_MAKE    = make -C $(WIKI_DIR) OUTPUT_DIR=../manual
ARCHIVE_FILE = yafmt.zip
BACKUP_DIR   = ~/Share/Dropbox/Backup

all:
	@echo "make manual  - generate html manual"
	@echo "make archive - copy all files inside a zip archive"
	@echo "make backup  - backup zipped files"
	@echo "make clean   - delete all generated files"

manual:
	$(WIKI_MAKE) all

archive:
	rm -f $(ARCHIVE_FILE)
	git archive -o tmp1.zip HEAD
	git --git-dir=wiki/.git archive --prefix=wiki/ -o tmp2.zip HEAD
	zipmerge yafmt.zip tmp1.zip tmp2.zip
	rm -f tmp1.zip tmp2.zip

backup: archive
	mv $(ARCHIVE_FILE) $(BACKUP_DIR)/$(ARCHIVE_FILE)

clean:
	$(WIKI_MAKE) clean
	rm -f $(ARCHIVE_FILE)
