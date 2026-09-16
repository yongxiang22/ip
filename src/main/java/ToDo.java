public  class ToDo extends Task {
        
        protected char extraIcon;
        public ToDo(String description) {
            super(description);
            
            this.extraIcon = 'T';
        
        }

        public char getExtraIcon(){
            return extraIcon;
        }

        public void setExtraIcon() {
            this.extraIcon = 'T';
        }

         

        @Override
        public String toString(){
            return"[" + getExtraIcon() + "][" + super.getStatusIcon() + "] " + super.description ;
        }

    }