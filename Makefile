WIKI_DIR    = wiki
MANUAL_DIR  = manual
WIKI_MAKE   = make -C $(WIKI_DIR) OUTPUT_DIR=../manual
BACKUP_FILE = yafmt.zip
BACKUP_DIR  = ~/Share/Dropbox/Backup

all: manual

manual:
	$(WIKI_MAKE) all

backup:
	rm -f $(BACKUP_FILE)
	git archive -o tmp1.zip HEAD
	git --git-dir=wiki/.git archive --prefix=wiki/ -o tmp2.zip HEAD
	zipmerge yafmt.zip tmp1.zip tmp2.zip
	rm -f tmp1.zip tmp2.zip
	mv $(BACKUP_FILE) $(BACKUP_DIR)/$(BACKUP_FILE)

clean:
	$(WIKI_MAKE) clean
