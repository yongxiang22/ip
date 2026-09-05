public  class ToDos extends Task {
        
        protected char extraIcon;
        public ToDos(String description) {
            super(description);
            
            this.extraIcon = 'T';
        
        }

        public char getExtraIcon(){
            return extraIcon;
        }

         

        @Override
        public String toString(){
            return"[ " + getExtraIcon() + "][" + super.getStatusIcon() + "] " + super.description ;
        }

    }