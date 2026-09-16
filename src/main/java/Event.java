public  class Event extends Task {
        
        protected char extraIcon;
        protected String from,to;
      
        public Event(String description, String from,String to) {
            
            super(description);
            this.from = from;
            this.to = to;
            this.extraIcon = 'E';
        
        }

        public char getExtraIcon(){
            return extraIcon;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }
        

         
        
        @Override
        public String toString(){
            
            return"[" + getExtraIcon() + "][" + super.getStatusIcon() + "] " + super.description + "(from: " + from + " to: " + to + ")";
        }

    }