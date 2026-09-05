public  class ToDo extends Task {
        
        protected char extraIcon;
        public ToDo(String description) {
            super(description);
            
            this.extraIcon = 'T';
        
        }

        public char getExtraIcon(){
            return extraIcon;
        }

         

        @Override
        public String toString(){
            return"[" + getExtraIcon() + "][" + super.getStatusIcon() + "] " + super.description ;
        }

    }